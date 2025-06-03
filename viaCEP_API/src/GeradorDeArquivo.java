import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeradorDeArquivo {

    private final String pasta = "arquivos";

    public GeradorDeArquivo() {
        // ✅ Cria a pasta se ela não existir
        File diretorio = new File(pasta);
        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
    }

    public void geraArquivoJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(pasta + "/" + endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();
    }

    public void salvarHistorico(String nomeUsuario, Endereco endereco) {
        try (FileWriter escrita = new FileWriter(pasta + "/historico.txt", true)) {
            String horario = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            escrita.write("👤 Usuário: " + nomeUsuario + "\n" +
                    "🕒 Data/Hora: " + horario + "\n" +
                    "📮 CEP consultado: " + endereco.cep() + "\n" +
                    "🏙️ Localidade: " + endereco.localidade() + " - " + endereco.uf() + "\n");
            escrita.write("----------------------------------------------------\n");
        } catch (IOException e) {
            System.out.println("⚠️ Erro ao salvar histórico: " + e.getMessage());
        }
    }

    // ✅ Gera relatório HTML com a consulta
    public void gerarRelatorioHtml(Endereco endereco) {
        try (FileWriter escrita = new FileWriter(pasta + "/relatorio_" + endereco.cep() + ".html")) {
            escrita.write("""
                    <!DOCTYPE html>
                    <html>
                    <head><meta charset="UTF-8"><title>Relatório de CEP</title></head>
                    <body>
                    <h2>📍 Endereço consultado</h2>
                    <ul>
                        <li><strong>CEP:</strong> %s</li>
                        <li><strong>Logradouro:</strong> %s</li>
                        <li><strong>Complemento:</strong> %s</li>
                        <li><strong>Bairro:</strong> %s</li>
                        <li><strong>Cidade:</strong> %s</li>
                        <li><strong>Estado:</strong> %s</li>
                    </ul>
                    </body>
                    </html>
                    """.formatted(endereco.cep(), endereco.logradouro(),
                    endereco.complemento(), endereco.bairro(),
                    endereco.localidade(), endereco.uf()));
        } catch (IOException e) {
            System.out.println("⚠️ Erro ao gerar relatório HTML.");
        }
    }
}

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        GeradorDeArquivo gerador = new GeradorDeArquivo();

        // ✅ Solicita o nome do usuário e dá boas-vindas
        System.out.print("👋 Olá! Seja bem-vindo ao programa ViaCEP!\nDigite seu nome: ");
        String nome = leitura.nextLine();
        System.out.println("😊 Olá, " + nome + "! Vamos consultar CEPs!");

        String opcao = "";

        // ✅ Laço principal até o usuário digitar "sair"
        while (!opcao.equalsIgnoreCase("sair")) {
            System.out.print("\n📮 Digite um número de CEP para consulta: ");
            String cep = leitura.nextLine().replaceAll("[^0-9]", "");

            // ✅ Validação: CEP precisa ter 8 dígitos
            if (cep.length() != 8) {
                System.out.println("⚠️ CEP inválido! Digite apenas 8 números. Ex: 01001000");
                continue;
            }

            try {
                // ✅ Consulta o CEP
                Endereco novoEndereco = consultaCep.buscaEndereco(cep);

                // ✅ Exibe o endereço formatado
                System.out.println("\n📌 Endereço encontrado:");
                System.out.println(novoEndereco);

                // ✅ Pergunta se deseja salvar a consulta
                System.out.print("\n💾 Deseja salvar esta consulta em JSON e histórico? (sim/não): ");
                String salvar = leitura.nextLine().trim().toLowerCase();

                if (salvar.equals("sim")) {
                    gerador.geraArquivoJson(novoEndereco);
                    gerador.salvarHistorico(nome, novoEndereco);
                    gerador.gerarRelatorioHtml(novoEndereco);
                    System.out.println("✅ Consulta salva na pasta 'arquivos/'.");
                } else {
                    System.out.println("❌ Consulta não salva.");
                }

            } catch (RuntimeException | IOException e) {
                System.out.println("❌ Erro: " + e.getMessage());
                System.out.println("🚫 Não foi possível localizar este CEP. Tente novamente. 📭");
            }

            // ✅ Pergunta se deseja continuar
            System.out.print("\n🔁 Deseja consultar outro CEP ou digite SAIR para encerrar: ");
            opcao = leitura.nextLine();
        }

        // ✅ Mensagem final
        System.out.println("\n🙏 Obrigado por utilizar o programa ViaCEP, " + nome + "!");
        System.out.println("👋 Até a próxima!");
        leitura.close();
    }
}

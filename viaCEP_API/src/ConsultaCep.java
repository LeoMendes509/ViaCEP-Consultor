import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // ✅ Verifica se o retorno possui "erro"
            if (response.body().contains("\"erro\"")) {
                throw new RuntimeException("CEP não encontrado.");
            }

            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível consultar o endereço. Verifique sua conexão.");
        }
    }
}

public record Endereco(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf
) {
    // ✅ Exibe o endereço formatado com emojis para facilitar a leitura
    @Override
    public String toString() {
        return """
                📮 CEP: %s
                🛣️ Logradouro: %s
                🧾 Complemento: %s
                🏘️ Bairro: %s
                🏙️ Cidade: %s
                🗺️ Estado (UF): %s
                """.formatted(cep, logradouro, complemento, bairro, localidade, uf);
    }
}

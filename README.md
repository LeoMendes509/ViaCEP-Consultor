# 📮 ViaCEP-Consultor

## 🇧🇷 Descrição

Bem-vindo ao **ViaCEP-Consultor**! 🎉

Este é um programa Java simples, porém poderoso, que permite consultar endereços a partir de CEPs brasileiros usando a API pública [ViaCEP](https://viacep.com.br).  
Além de exibir o endereço formatado com emojis e mensagens amigáveis, o programa gera:

- 📁 Arquivos JSON para cada CEP consultado, salvos em uma pasta dedicada `arquivos/`
- 📊 Um relatório HTML com todos os endereços consultados durante a execução
- 💾 Histórico das consultas, opcional para salvar ou não
- 🚀 Validação de entrada e tratamento de erros para uma experiência suave

### Funcionalidades principais:

- 🎉 Boas-vindas personalizada com nome do usuário
- 🔢 Validação rigorosa do CEP (aceita apenas números)
- ❌ Tratamento de CEP inválido sem travar o programa
- 🔄 Consultas ilimitadas até o usuário decidir sair
- 📄 Geração automática de arquivos JSON e relatório HTML
- 🥳 Mensagens com emojis para melhorar a interação

---

## 🇺🇸 Description

Welcome to **ViaCEP-Consultor**! 🎉

This is a simple but powerful Java program that allows you to fetch Brazilian address data from postal codes (CEPs) using the public [ViaCEP API](https://viacep.com.br).  
Besides showing formatted addresses with emojis and friendly messages, the program creates:

- 📁 JSON files for each queried CEP, saved inside the `arquivos/` folder
- 📊 An HTML report compiling all queried addresses during the program run
- 💾 Optional history saving of consultations
- 🚀 Input validation and error handling for a smooth experience

### Main features:

- 🎉 Personalized welcome with user name
- 🔢 Strict CEP validation (numbers only)
- ❌ Invalid CEP error handling without crashing
- 🔄 Unlimited CEP lookups until user decides to exit
- 📄 Automatic generation of JSON files and HTML report
- 🥳 Emoji-rich messages for better user interaction

---

## 💻 Como rodar

1. Clone o repositório  
2. Compile com `javac` e rode `java Principal`  
3. Siga as instruções no terminal para consultar CEPs

---

## 📂 Estrutura

- `Principal.java` – classe principal do programa  
- `ConsultaCep.java` – consulta via API ViaCEP  
- `Endereco.java` – registro com informações do endereço  
- `GeradorDeArquivo.java` – gera arquivos JSON  
- `GeradorDeRelatorio.java` – gera relatório HTML  

---

## 📬 Contato

Leonardo Mendes Rodrigues  
📧 lmrodrigues.dev509@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/leonardo-mendes-developer/)  

---

✨ Obrigado por usar o ViaCEP-Consultor! ✨

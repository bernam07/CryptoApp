# NewsApp - Leitor de Notícias (Programação de Dispositivos Móveis)

![Plataforma](https://img.shields.io/badge/Plataforma-Android-3DDC84.svg?style=for-the-badge&logo=android)
![Linguagem](https://img.shields.io/badge/Feito%20com-Kotlin-0095D5.svg?style=for-the-badge&logo=kotlin)
![Arquitetura](https://img.shields.io/badge/Arquitetura-Clean_Arch-orange.svg?style=for-the-badge)

## 📖 Sobre o Projeto

Este projeto é uma aplicação nativa de leitura de notícias para Android, desenvolvida no âmbito da unidade curricular de **Programação de Dispositivos Móveis (PDM)**.

A aplicação consome dados em tempo real da **NewsAPI.org**, permitindo ao utilizador consultar manchetes de diversas fontes internacionais. O projeto destaca-se pela implementação de **Clean Architecture**, separando rigorosamente as camadas de dados, domínio e interface, garantindo um código modular, testável e escalável.

## ✨ Funcionalidades

* **Múltiplas Fontes:** Acesso rápido a notícias de fontes como TechCrunch, Bloomberg, ESPN, BBC News, Wired, entre outras.
* **Leitura de Artigos:** Integração com **WebView** para carregar o conteúdo original da notícia dentro da app.
* **Navegação Intuitiva:**
    * **Ecrã Inicial (Home):** Menu centralizado para escolha da fonte de notícias.
    * **Lista de Artigos:** *Scroll* fluido com imagens de destaque e títulos.
* **UI Dinâmica:** A barra de topo (TopBar) adapta-se automaticamente para mostrar o nome da fonte selecionada e esconde-se no ecrã principal.
* **Carregamento de Imagens:** Processamento assíncrono e eficiente de imagens da web.

## 🎨 Design e UI

A interface foi construída 100% em **Jetpack Compose**, seguindo as diretrizes modernas do Material Design:
* **Cards Interativos:** Apresentação limpa das notícias com cantos arredondados e sombras suaves.
* **Layout Adaptável:** Uso de `LazyColumn` para listas eficientes e `Scaffold` para estrutura da página.
* **Navegação:** Transições fluídas entre o menu inicial, a lista e o detalhe da notícia.

## 🛠️ Tecnologias Utilizadas

* **[Kotlin](https://kotlinlang.org/):** Linguagem de programação principal.
* **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Toolkit moderno para construção de UI nativa.
* **[OkHttp](https://square.github.io/okhttp/):** Cliente HTTP para realizar os pedidos à API de forma eficiente.
* **[Coil](https://coil-kt.github.io/coil/):** Biblioteca para carregamento assíncrono de imagens.
* **Arquitetura (Clean Arch):**
    * **Domain Layer (`GetArticlesUseCase`):** Lógica de negócio pura e modelos de dados independentes.
    * **Data Layer (`ArticlesRepositoryImpl`):** Gestão de pedidos à API e parsing de JSON.
    * **UI Layer (`ArticlesListViewModel`):** Gestão de estado (StateFlow) e componentes visuais.

## 🚀 Como Executar

Para compilar e executar o projeto, precisas de configurar a API Key.

1.  **Pré-requisitos:**
    * Android Studio (Versão Koala ou superior recomendada).
    * Uma chave gratuita da [NewsAPI.org](https://newsapi.org/).

2.  **Configurar a Chave (Segurança):**
    * Cria um ficheiro `local.properties` na raiz do projeto (se não existir).
    * Adiciona a seguinte linha:
        ```properties
        NEWS_API_KEY=cola_aqui_a_tua_api_key
        ```

3.  **Executar:**
    * Abre o projeto no Android Studio.
    * Clica em "Sync Project with Gradle Files".
    * Seleciona o emulador e clica no botão "Run".

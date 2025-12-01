# CryptoApp - Monitor de Criptomoedas (PDM)

![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android)
![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin)
![Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose)
![Architecture](https://img.shields.io/badge/Architecture-Clean%20Arch-orange?style=for-the-badge)

## 📖 Sobre o Projeto

A **CryptoApp** é uma aplicação nativa Android desenvolvida no âmbito da unidade curricular de **Programação de Dispositivos Móveis (PDM)**.

O objetivo da aplicação é permitir o acompanhamento em tempo real do mercado de criptomoedas. A app consome dados da **CoinPaprika API**, apresentando uma listagem das principais moedas e os seus detalhes financeiros essenciais, com uma interface moderna e otimizada para o tema escuro ("Dark Mode").

## ✨ Funcionalidades

* **Listagem em Tempo Real:** Visualização das Top 50 criptomoedas (Bitcoin, Ethereum, etc.).
* **Indicadores Visuais:**
    * Variação de preço a 24h com código de cores (Verde para subida, Vermelho para descida).
    * Logótipos oficiais de cada moeda carregados dinamicamente.
* **Detalhes de Mercado:**
    * Preço atual em Dólares (USD).
    * Ranking global.
    * Capitalização de Mercado (Market Cap).
    * Volume nas últimas 24h.
    * Supply em circulação.
* **UI/UX:**
    * Interface totalmente construída em **Jetpack Compose**.
    * **Dark Mode Forçado:** Tema azul escuro personalizado para melhor visualização e estilo "Crypto".
    * Navegação fluída entre lista e detalhes.

## 🛠️ Stack Tecnológico

* **Linguagem:** [Kotlin](https://kotlinlang.org/)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material Design 3)
* **Networking:** [OkHttp](https://square.github.io/okhttp/) (Pedidos HTTP eficientes e parsing manual de JSON).
* **Imagens:** [Coil](https://coil-kt.github.io/coil/) (Carregamento assíncrono de imagens da web).
* **Arquitetura:** Clean Architecture (MVVM).

## 🏗️ Arquitetura (Clean Architecture)

O projeto segue rigorosamente os princípios de separação de responsabilidades, dividido em três camadas:

1.  **Domain Layer (Domínio):**
    * Contém as regras de negócio e modelos puros (`Coin`).
    * Define as interfaces (`CoinRepository`) e UseCases (`GetCoinsUseCase`).
    * *Independente de frameworks Android.*

2.  **Data Layer (Dados):**
    * Implementa o repositório (`CoinRepositoryImpl`).
    * Gere a comunicação com a API da CoinPaprika.
    * Faz o tratamento de dados (parsing JSON seguro para lidar com falhas de tipos numéricos).

3.  **Presentation Layer (UI):**
    * **ViewModel (`CoinsListViewModel`):** Gere o estado da UI (`CoinsListState`) e comunica com o Domínio.
    * **Composables:** Ecrãs (`CoinsListView`, `CoinDetailView`) e componentes (`CoinViewCell`).

## 🚀 Como Executar

Este projeto utiliza a API pública da CoinPaprika, pelo que **não é necessário configurar chaves de API**.

1.  **Pré-requisitos:**
    * Android Studio (Versão Koala ou superior recomendada).
    * JDK 17 ou superior.

2.  **Instalação:**
    ```bash
    # 1. Clona este repositório
    git clone https://github.com/bernam07/CryptoApp.git

    # 2. Abre o projeto no Android Studio
    ```

3.  **Compilação:**
    * Aguarda a sincronização do Gradle.
    * No menu, seleciona **Build > Clean Project** (para garantir que não há cache antiga).
    * Seleciona um emulador ou dispositivo físico.
    * Clica em **Run**.

## 🔗 Créditos

* Dados fornecidos por [CoinPaprika API](https://api.coinpaprika.com/).
* Ícones/Logos fornecidos por CoinPaprika Static Assets.

---
**Desenvolvido por Bernardo Martins**

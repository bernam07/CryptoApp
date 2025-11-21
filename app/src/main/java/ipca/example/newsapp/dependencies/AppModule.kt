package ipca.example.newsapp.dependencies

import ipca.example.newsapp.data.repository.ArticlesRepositoryImpl
import ipca.example.newsapp.domain.repository.ArticlesRepository
import ipca.example.newsapp.domain.usecase.GetArticlesUseCase

object AppModule {
    // 1. Criar o repositório
    private val articlesRepository: ArticlesRepository by lazy {
        ArticlesRepositoryImpl()
    }

    // 2. Criar o UseCase injetando o repositório
    val getArticlesUseCase: GetArticlesUseCase by lazy {
        GetArticlesUseCase(articlesRepository)
    }
}
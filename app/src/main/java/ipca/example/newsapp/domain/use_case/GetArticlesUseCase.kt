package ipca.example.newsapp.domain.usecase

import ipca.example.newsapp.domain.model.Article
import ipca.example.newsapp.domain.repository.ArticlesRepository

class GetArticlesUseCase(private val repository: ArticlesRepository) {
    suspend operator fun invoke(source: String): List<Article> {
        return repository.getArticles(source)
    }
}
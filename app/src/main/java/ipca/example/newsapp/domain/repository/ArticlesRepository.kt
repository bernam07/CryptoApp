package ipca.example.newsapp.domain.repository

import ipca.example.newsapp.domain.model.Article

interface ArticlesRepository {
    suspend fun getArticles(source: String): List<Article>
}
package ipca.example.newsapp.data.repository

import ipca.example.newsapp.BuildConfig
import ipca.example.newsapp.domain.model.Article
import ipca.example.newsapp.domain.repository.ArticlesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

class ArticlesRepositoryImpl : ArticlesRepository {

    private val client = OkHttpClient()

    override suspend fun getArticles(source: String): List<Article> {
        return withContext(Dispatchers.IO) {
            val apiKey = BuildConfig.API_KEY
            val request = Request.Builder()
                .url("https://newsapi.org/v2/top-headlines?sources=$source&apiKey=$apiKey")
                .build()

            val response = client.newCall(request).execute()

            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val responseBody = response.body?.string() ?: throw IOException("Empty body")
            val jsonResult = JSONObject(responseBody)
            val articlesList = mutableListOf<Article>()

            if (jsonResult.optString("status") == "ok") {
                val articlesJson = jsonResult.getJSONArray("articles")
                for (i in 0 until articlesJson.length()) {
                    val item = articlesJson.getJSONObject(i)

                    // Mapeamento do JSON para o Modelo de Domínio
                    val article = Article(
                        title = item.optString("title"),
                        description = item.optString("description"),
                        url = item.optString("url"),
                        urlToImage = item.optString("urlToImage"),
                        publishedAt = item.optString("publishedAt")
                    )
                    articlesList.add(article)
                }
            }
            articlesList
        }
    }
}
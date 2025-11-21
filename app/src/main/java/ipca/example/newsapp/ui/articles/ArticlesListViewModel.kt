package ipca.example.newsapp.ui.articles

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ipca.example.newsapp.dependencies.AppModule
import ipca.example.newsapp.domain.model.Article
import kotlinx.coroutines.launch

data class ArticlesListState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class ArticlesListViewModel : ViewModel() {

    var uiState = mutableStateOf(ArticlesListState())
        private set

    private val getArticlesUseCase = AppModule.getArticlesUseCase

    fun fetchArticles(source: String) {
        uiState.value = uiState.value.copy(isLoading = true, error = null)

        viewModelScope.launch {
            try {
                val articles = getArticlesUseCase(source)

                uiState.value = uiState.value.copy(
                    isLoading = false,
                    articles = articles
                )
            } catch (e: Exception) {
                e.printStackTrace()
                uiState.value = uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Erro desconhecido"
                )
            }
        }
    }
}
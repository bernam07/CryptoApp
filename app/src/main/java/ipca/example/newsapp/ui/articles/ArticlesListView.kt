package ipca.example.newsapp.ui.articles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ipca.example.newsapp.ui.theme.NewsAppTheme
import ipca.example.newsapp.domain.model.Article
import ipca.example.newsapp.utils.encodeUrl

@Composable
fun ArticlesListView(
    modifier: Modifier = Modifier,
    navController: NavController,
    source: String = ""
) {
    val viewModel : ArticlesListViewModel = viewModel()
    val uiState by viewModel.uiState

    LaunchedEffect(source) {
        viewModel.fetchArticles(source)
    }

    ArticlesListViewContent(
        modifier = modifier,
        uiState = uiState,
        navController = navController
    )
}

@Composable
fun ArticlesListViewContent(
    modifier: Modifier = Modifier,
    uiState: ArticlesListState,
    navController: NavController
) {
    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        if (uiState.isLoading) {
            CircularProgressIndicator()
        } else if (uiState.error != null) {
            Text(uiState.error ?: "Erro desconhecido",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center)
        } else {
            LazyColumn(modifier = modifier.fillMaxSize()) {
                itemsIndexed(items = uiState.articles) { index, article ->
                    ArticleViewCell(article){
                        val encodedUrl = article.url?.encodeUrl() ?: ""
                        navController.navigate("article/$encodedUrl")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlesListViewPreview() {
    NewsAppTheme {
        ArticlesListViewContent(
            modifier = Modifier.padding(10.dp),
            uiState = ArticlesListState(
                articles = listOf(
                    Article("T1", "D1", "url", "img", "date"),
                    Article("T2", "D2", "url", "img", "date")
                ),
                isLoading = false,
                error = null
            ),
            navController = rememberNavController()
        )
    }
}
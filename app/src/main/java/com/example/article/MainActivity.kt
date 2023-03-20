package com.example.article

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopBanner(header = stringResource(R.string.banner_of_page ),
                        firstParagraph = stringResource(R.string.paragraph_1),
                        secondParagraph = stringResource(R.string.paragraph_2))
                }
            }
        }
    }
}

@Composable
fun TopBanner (header: String, firstParagraph: String, secondParagraph: String) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Box {
            Image(painter = image, contentDescription = null)
    }
    ArticleText(
        header = header,
        firstParagraph = firstParagraph,
        secondParagraph = secondParagraph)

}

@Composable
fun ArticleText(header: String, firstParagraph: String, secondParagraph: String) {
    Column {
        Text(
            text = header,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = firstParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 24.dp, end = 16.dp))
        Text(
            text = secondParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArticleTheme {
        TopBanner(header = stringResource(R.string.banner_of_page),
            firstParagraph = stringResource(R.string.paragraph_1),
            secondParagraph = stringResource(R.string.paragraph_2))
    }
}
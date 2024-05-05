package com.example.testjetpack

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testjetpack.ui.theme.TestJetpackTheme

val alignYourBodyData = listOf(
    BodyElement(R.drawable.ic_launcher_background, R.string.text1),
    BodyElement(R.drawable.ic_launcher_background, R.string.text2),
    BodyElement(R.drawable.ic_launcher_background, R.string.text3),
    BodyElement(R.drawable.ic_launcher_background, R.string.text1),
    BodyElement(R.drawable.ic_launcher_background, R.string.text2),
    BodyElement(R.drawable.ic_launcher_background, R.string.text3),
)
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text,imageColor = Color.Magenta,
                textColor = Color.Blue)
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyRowPreview() {
    TestJetpackTheme {
        AlignYourBodyRow(
            modifier = Modifier.padding(8.dp)
        )
    }
}
data class BodyElement(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)



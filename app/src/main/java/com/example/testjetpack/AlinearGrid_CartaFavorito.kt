package com.example.testjetpack

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val favoriteCollectionsData = listOf(
    CartElement(R.drawable.ab1_inversions, R.string.text1),
    CartElement(R.drawable.ab1_inversions, R.string.text2),
    CartElement(R.drawable.ab1_inversions, R.string.text3),
    CartElement(R.drawable.ab1_inversions, R.string.text1),
    CartElement(R.drawable.ab1_inversions, R.string.text2),
    CartElement(R.drawable.ab1_inversions, R.string.text3),
)

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(drawable = item.drawables, text = item.text, modifier = Modifier.height(80.dp))
        }
    }
}
data class CartElement(
    @DrawableRes val drawables: Int,
    @StringRes val text: Int
)

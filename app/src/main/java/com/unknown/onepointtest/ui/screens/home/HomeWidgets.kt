package com.unknown.onepointtest.ui.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unknown.onepointtest.domain.Tree
import com.unknown.onepointtest.ui.theme.OnepointTestTheme


@Composable
fun TreeItem(
    modifier : Modifier = Modifier,
    tree: Tree = Tree(id = "pihfrioughr", name = "Test Tree", adresse = "Paris 12", espece = "Something", hauteur = 2, circonference = 23),
    onNavigateTo : (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onNavigateTo(tree.id)
            },
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = "Nom")
                Text(text = tree.name)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = "Espece")
                Text(text = tree.espece)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = "Hauteur")
                Text(text = tree.hauteur.toString())
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = "Circonference")
                Text(text = tree.circonference.toString())
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = "Adresse")
                Text(text = tree.adresse, modifier = Modifier.padding(start = 8.dp))
            }
        }

    }

}

@Preview
@Composable
fun TreeItemPreview() {

    OnepointTestTheme {
        TreeItem(onNavigateTo = {
            nav(it)
        })
    }
}

fun nav(id : String){
    Log.d("NAVIGATION", "navigation de $id triggered" )
}
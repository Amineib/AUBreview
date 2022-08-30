package com.unknown.onepointtest.data.repository

import com.unknown.onepointtest.data.remote.TreeApi
import com.unknown.onepointtest.domain.Tree
import com.unknown.onepointtest.domain.TreeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.withContext

class TreeRepositoryImpl(
    private val treeService : TreeApi,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : TreeRepository {

    override suspend fun getTrees(count: Int): List<Tree> {
        return withContext(defaultDispatcher){
            treeService.getTrees(count).records.map {
                Tree(
                    it.records.id,
                    it.records.tree.nom,
                    it.records.tree.espece,
                    it.records.tree.hauteur,
                    it.records.tree.circonference,
                    it.records.tree.adresse,
                )
            }
        }
    }

    override suspend fun getTree(id: String): Tree {
        return withContext(defaultDispatcher){
            val data = treeService.getTreeDetail(id).record
            Tree(
                data.id,
                data.tree.nom,
                data.tree.espece,
                data.tree.hauteur,
                data.tree.circonference,
                data.tree.adresse
            )
        }
    }
}
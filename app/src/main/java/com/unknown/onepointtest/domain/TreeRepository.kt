package com.unknown.onepointtest.domain


interface TreeRepository {

    suspend fun getTrees(count: Int) : List<Tree>
    suspend fun getTree(id: String) : Tree
}
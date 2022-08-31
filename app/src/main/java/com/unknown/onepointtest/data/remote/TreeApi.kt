package com.unknown.onepointtest.data.remote

import com.unknown.onepointtest.data.remote.response.TreeListResponse
import com.unknown.onepointtest.data.remote.response.TreeDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TreeApi {

    @GET("catalog/datasets/les-arbres/records")
    suspend fun getTrees(
        @Query("rows") rows : Int
    ): TreeListResponse

    @GET("catalog/datasets/les-arbres/records/{treeId}")
    suspend fun getTreeDetail(
        @Path("treeId") TreeId : String
    ): TreeDetailResponse

}
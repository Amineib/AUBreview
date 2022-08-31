package com.unknown.onepointtest.domain.use_case

import com.unknown.onepointtest.common.Resource
import com.unknown.onepointtest.domain.Tree
import com.unknown.onepointtest.domain.TreeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTreesUseCase @Inject constructor(
    private val repo : TreeRepository
) {
    operator fun invoke(count : Int = 20) : Flow<Resource<List<Tree>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repo.getTrees(count)
            emit(Resource.Success(data))
        }catch(e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected HttpException occured.."))
        }catch (e: IOException){
            emit(Resource.Error(message = e.localizedMessage ?: "Couldn't reach server.."))
        }
    }
}
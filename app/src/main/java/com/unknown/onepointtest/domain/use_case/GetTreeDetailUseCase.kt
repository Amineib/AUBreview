package com.unknown.onepointtest.domain.use_case

import com.unknown.onepointtest.common.Resource
import com.unknown.onepointtest.domain.Tree
import com.unknown.onepointtest.domain.TreeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetTreeDetailUseCase @Inject constructor(
    private val repo : TreeRepository
) {
    operator fun invoke(id: String) : Flow<Resource<Tree>>  = flow {
        try {
            emit(Resource.Loading())
            kotlinx.coroutines.delay(1500) //simulate network call taking too long
            val data  = repo.getTree(id)
            emit(Resource.Success(data))
        }
        catch(e: HttpException){ //http response not successful
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected HttpException occured.."))
        }catch (e: IOException){ //cant reach remote api
            emit(Resource.Error(message = e.localizedMessage ?: "Couldn't reach server.."))
        }
        catch(e: Exception){
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error.."))
        }
    }
}
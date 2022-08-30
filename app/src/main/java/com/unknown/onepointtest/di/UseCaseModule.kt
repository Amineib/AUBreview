package com.unknown.onepointtest.di

import com.unknown.onepointtest.domain.TreeRepository
import com.unknown.onepointtest.domain.use_case.GetTreeDetailUseCase
import com.unknown.onepointtest.domain.use_case.GetTreesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {


    @Singleton
    @Provides
    fun providesGetTreesListUseCase(
        repo : TreeRepository
    ) : GetTreesUseCase {
        return GetTreesUseCase(
            repo
        )
    }


    @Singleton
    @Provides
    fun providesGetTreeDetailUseCase(
        repo : TreeRepository
    ) : GetTreeDetailUseCase {
        return GetTreeDetailUseCase(
            repo
        )
    }
}
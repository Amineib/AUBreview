package com.unknown.onepointtest.di

import com.unknown.onepointtest.data.remote.TreeApi
import com.unknown.onepointtest.data.repository.TreeRepositoryImpl
import com.unknown.onepointtest.domain.TreeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideTreeRepository(
        treeService: TreeApi
    ): TreeRepository {
        return TreeRepositoryImpl(
            treeService
        )
    }
}
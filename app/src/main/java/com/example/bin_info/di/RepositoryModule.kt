package com.example.bin_info.di

import com.example.bin_info.external.data.impl.ExternalRepositoryImpl
import com.example.bin_info.external.domain.ExternalRepository
import com.example.bin_info.history.data.impl.HistoryRepositoryImpl
import com.example.bin_info.history.domain.HistoryRepository
import com.example.bin_info.info.data.impl.InfoRepositoryImpl
import com.example.bin_info.info.domain.api.InfoRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val IO_DISPATCHER = "ioDispatcher"

val repositoryModule = module {

    single<InfoRepository> {
        InfoRepositoryImpl(
            networkClient = get(),
            ioDispatcher = get(named(IO_DISPATCHER)),
            infoConverter = get()
        )
    }

    single<HistoryRepository> {
        HistoryRepositoryImpl(
            appDatabase = get(),
            infoConverter = get()
        )
    }

    single<ExternalRepository> {
        ExternalRepositoryImpl(
            context = androidContext()
        )
    }
}
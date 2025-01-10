package com.example.bin_info.di

import com.example.bin_info.info.data.impl.InfoRepositoryImpl
import com.example.bin_info.info.domain.api.InfoRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val IO_DISPATCHER = "ioDispatcher"

val repositoryModule = module {

    single<InfoRepository> {
        InfoRepositoryImpl(
            networkClient = get(),
            ioDispatcher = get(named(IO_DISPATCHER)),
        )
    }
}
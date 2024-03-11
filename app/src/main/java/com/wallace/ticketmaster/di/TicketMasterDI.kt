package com.wallace.ticketmaster.di

import com.wallace.ticketmaster.data.service.ServiceManager
import com.wallace.ticketmaster.data.storage.DataStoreManager
import com.wallace.ticketmaster.domain.repository.EventsRepository
import com.wallace.ticketmaster.domain.repository.EventsRepositoryImpl
import com.wallace.ticketmaster.domain.usecase.EventsUseCase
import com.wallace.ticketmaster.domain.usecase.EventsUseCaseImpl
import com.wallace.ticketmaster.presentation.viewmodel.EventsViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::ServiceManager)
    single {
        DataStoreManager(context = get())
    }

    factoryOf(::EventsRepositoryImpl) bind EventsRepository::class
    factoryOf(::EventsUseCaseImpl) bind EventsUseCase::class

    viewModel {
        EventsViewModel(
            useCase = get(),
            dispatcherDefault = Dispatchers.Default
        )
    }
}
package com.wallace.ticketmaster

import android.app.Application
import com.wallace.ticketmaster.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class TicketMasterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TicketMasterApplication)
            modules(appModule)
        }
    }
}

package com.maciejmalak.dbdemo.di

import com.maciejmalak.data.db.Db
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    /*
    It's a top level module and won't be deregistered thus we will get single instance always.
     */
    single { Db.DbInitializer.getInstance(androidContext()) }
    single { Db.DbInitializer.getUserDao(androidContext()) }
}
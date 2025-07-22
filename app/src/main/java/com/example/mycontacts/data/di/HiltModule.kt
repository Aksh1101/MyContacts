package com.example.mycontacts.data.di

import android.app.Application
import androidx.room.Room
import com.example.mycontacts.data.database.ContactDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object HiltModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application) : ContactDataBase {
        return Room.databaseBuilder(
            application.baseContext,
            ContactDataBase::class.java,
            "contact_db"
        ).fallbackToDestructiveMigration(false).build()
    }
}
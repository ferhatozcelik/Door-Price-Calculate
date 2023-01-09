package com.ferhatozcelik.doorpricecalculate.di

import android.app.Application
import androidx.room.Room
import com.ferhatozcelik.doorpricecalculate.data.local.AppDatabase
import com.ferhatozcelik.doorpricecalculate.data.local.SearchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: AppDatabase.Callback): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "local_database")
            .fallbackToDestructiveMigration().addCallback(callback).build()
    }

    @Provides
    fun provideSearchDao(db: AppDatabase): SearchDao {
        return db.getSearchDao()
    }
}
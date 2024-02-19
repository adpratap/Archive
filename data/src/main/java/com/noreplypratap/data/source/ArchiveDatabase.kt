package com.noreplypratap.data.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.noreplypratap.data.model.DArchive

@Database(entities = [DArchive::class], version = 1 , exportSchema = false)
abstract class ArchiveDatabase: RoomDatabase() {
    abstract fun getArchiveDao(): ArchiveDao

    companion object {
        @Volatile
        private var instance : ArchiveDatabase? = null

        fun createArchiveDatabase(context: Context) : ArchiveDatabase {

            if (instance == null){
                synchronized(this){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ArchiveDatabase::class.java,
                        "ArchiveDatabase"
                    ).build()
                }
            }
            return instance!!
        }
    }

}
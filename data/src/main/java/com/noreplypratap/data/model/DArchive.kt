package com.noreplypratap.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "archive_table")
data class DArchive(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val body: String,
    val isStarted: Boolean,
    val imp: Boolean
)

package com.noreplypratap.data.mapper

import com.noreplypratap.data.model.DArchive
import com.noreplypratap.domain.model.Archive

fun Archive.toDArchive(imp: Boolean): DArchive = DArchive(id, title, body, isStarted,imp)

fun DArchive.toArchive(): Archive = Archive(id, title, body, isStarted)

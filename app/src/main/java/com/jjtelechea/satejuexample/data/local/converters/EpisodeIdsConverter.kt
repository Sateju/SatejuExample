package com.jjtelechea.satejuexample.data.local.converters

import androidx.room.TypeConverter

class EpisodeIdsConverter {

    @TypeConverter
    fun fromList(list: List<Int>): String = list.joinToString(separator = ",")

    @TypeConverter
    fun toList(value: String): List<Int> =
        if (value.isBlank()) emptyList()
        else value.split(",").map { it.toInt() }
}
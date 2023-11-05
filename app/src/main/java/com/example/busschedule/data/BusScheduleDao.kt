package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Delete
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {

    @Query("SELECT * from busSchedules WHERE id = :id")
    fun getItem(id: Int): Flow<BusSchedule>
    @Query("SELECT * from busschedules ORDER BY arrivalTime ASC")
    fun getAll(): Flow<List<BusSchedule>>
    @Query("SELECT * from busschedules ORDER BY stopName ASC")
    fun getAllByName(): Flow<List<BusSchedule>>
    @Query("SELECT * from busschedules WHERE stopName = :stopName")
    fun getByName(stopName: String): Flow<List<BusSchedule>>
}
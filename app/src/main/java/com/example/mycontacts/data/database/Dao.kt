package com.example.mycontacts.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("Select * FROM contact_table Order By 'userName ' ASC")
    fun getContactsSortedByName(): Flow<List<Contact>>

    @Query("Select * FROM contact_table Order By dateOfCreation ASC")
    fun getContactsSortedByDate(): Flow<List<Contact>>
}
package com.ferhatozcelik.doorpricecalculate.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ferhatozcelik.doorpricecalculate.data.entity.Cost

@Dao
interface SearchDao {

    @Query("SELECT * FROM search_table ORDER BY searchWordCreateAt DESC LIMIT 5")
    fun getSearch(): LiveData<List<Cost>>

    @Query("SELECT * FROM search_table ORDER BY searchWordCreateAt ASC")
    suspend fun getActiveAllSearch(): List<Cost>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(search: Cost)

    @Update
    suspend fun update(search: Cost)

    @Delete
    suspend fun delete(search: Cost)

    @Query("SELECT * FROM search_table WHERE searchWord= :searchWord")
    suspend fun getItemByIdWord(searchWord: String): List<Cost>

    @Transaction
    suspend fun insertOrUpdate(search: Cost) {
        val itemsFromDB: List<Cost> = getItemByIdWord(search.searchWord!!)
        val itemsFromAllData: List<Cost>? = getActiveAllSearch()
        if (itemsFromDB.isEmpty()) {
            if (itemsFromAllData!!.isNotEmpty() && itemsFromAllData.size >= 5) {
                delete(itemsFromAllData[0])
            }
            insert(search)
        } else {
            update(Cost(itemsFromDB[0].searchId!!, search.searchWord, search.searchWordCreateAt))
        }
    }

}
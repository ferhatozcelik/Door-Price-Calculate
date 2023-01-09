package com.ferhatozcelik.doorpricecalculate.repository

import com.ferhatozcelik.doorpricecalculate.data.entity.Cost
import com.ferhatozcelik.doorpricecalculate.data.local.SearchDao
import com.ferhatozcelik.doorpricecalculate.data.remote.AppApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CostRepository @Inject constructor(
    private val appApi: AppApi,
    private val searchDao: SearchDao
) {

    fun getLastAllSearch() = searchDao.getSearch()

    suspend fun lastWordInsert(search: Cost) = searchDao.insertOrUpdate(search)

}
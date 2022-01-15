package com.awaresiel.testtasks.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.awaresiel.testtasks.TestTaskApplication
import com.awaresiel.testtasks.data.SongsData
import com.awaresiel.testtasks.repository.SongsRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SongsModels @Inject constructor(private val  repository: SongsRepository): ViewModel() {

    init {
        TestTaskApplication.appComponent.inject(songsModels = this)
    }

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val songsLiveData = MutableLiveData<ArrayList<SongsData>>().apply { value = arrayListOf() }
    val songsDataForAdapter = MutableLiveData<ArrayList<SongsData>>().apply { value = arrayListOf() }
    var id: Int? = null

    /*
        Function for getting tracks from api
        @Param - id where id = collectionId
     */
    fun getSongs(){
        scope.launch {
            val songs = id?.let { repository.getSongsList(it) }
            songsLiveData.postValue(songs)
            songsDataForAdapter.postValue(songs?.filter { it.wrapperType != "collection" } as ArrayList<SongsData>?)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()


}
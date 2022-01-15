package com.awaresiel.testtasks.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awaresiel.testtasks.TestTaskApplication
import com.awaresiel.testtasks.R
import com.awaresiel.testtasks.adapters.AdapterSongs
import com.awaresiel.testtasks.models.SongsModels
import com.bumptech.glide.Glide

import java.lang.IllegalArgumentException
import java.lang.IndexOutOfBoundsException
import java.lang.StringBuilder
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_songs_view.*


class SongsViewFragment : Fragment() {

    @Inject
    lateinit var songsModel: SongsModels
    private lateinit var adapterSongs: AdapterSongs


    companion object {
        fun newInstance() = SongsViewFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TestTaskApplication.appComponent.inject(songsViewFragment = this@SongsViewFragment)

        try {
            val id = arguments?.let { SongsViewFragmentArgs.fromBundle(it).id }
            retainInstance = true
            if (songsModel.id == null){
                songsModel.id = id

            }
            else if(songsModel.id != id){
                songsModel.id = id
            }
            songsModel.getSongs()
        }
        catch (e: IllegalArgumentException){

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_songs_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapterSongs = AdapterSongs(arrayListOf())
        songsView.adapter = adapterSongs
        songsModel.songsLiveData.observe(viewLifecycleOwner, { data ->

            try {
                textViewCollectionName.text = data[0].collectionName
                textViewArtistName.text = data[0].artistName
                textViewGenre.text = data[0].primaryGenreName
                textViewCountry.text = data[0].country
                textViewPrice.text = data[0].collectionPrice.toString()
                textViewDateRelease.text = data[0].releaseDate
                textViewTrackNumber.text = (StringBuilder().append("Number of tracks: ")
                    .append(data[0].trackCount)).toString()
                Glide.with(this).load(data[0].artworkUrl60).into(imageViewAlbums)
            } catch (e: IndexOutOfBoundsException) {
                Log.i("STATUS DATA", "Data is loading")
            }

        })

        songsModel.songsDataForAdapter.observe(viewLifecycleOwner, {
            Log.i("STATUS DATA", songsModel.songsDataForAdapter.value!!.toString())
            adapterSongs.update(songsModel.songsDataForAdapter.value!!)
        })
    }
}

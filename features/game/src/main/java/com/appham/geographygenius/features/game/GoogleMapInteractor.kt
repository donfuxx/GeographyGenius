package com.appham.geographygenius.features.game

import com.appham.geographygenius.domain.entities.Coords
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class GoogleMapInteractor(
    private val map: GoogleMap
): MapInteractor {

    override fun addMarker(coords: Coords, title: String) {
        map.addMarker(MarkerOptions().position(coords.toLatLng()).title(title))
    }

    override fun moveCamera(coords: Coords) {
        map.moveCamera(CameraUpdateFactory.newLatLng(coords.toLatLng()))
    }

}

interface MapInteractor {
    fun addMarker(coords: Coords, title: String)
    fun moveCamera(coords: Coords)
}

suspend fun MapView.getMapInteractor(): GoogleMapInteractor =
    suspendCoroutine { cont ->
        getMapAsync { map ->
            cont.resume(GoogleMapInteractor(map))
        }
    }

fun Coords.toLatLng() = LatLng(lat, lng)
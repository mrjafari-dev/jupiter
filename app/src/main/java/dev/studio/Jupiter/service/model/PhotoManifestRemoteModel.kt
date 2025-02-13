package dev.studio.Jupiter.service.model

import com.google.gson.annotations.SerializedName

data class PhotoManifestRemoteModel(

    @SerializedName("landing_date")
    val landingDate: String,
    @SerializedName("lunch_date")
    val lunchDate: String,
    @SerializedName("max_date")
    val maxDate: String,
    @SerializedName("max_sol")
    val maxSol: String,

    val name: String,
    val photos: List<ManifestPhotoRemoteModel>,
    val status: String,
    @SerializedName("total_photos")
    val totalPhotos: Int,


    )
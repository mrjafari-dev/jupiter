package dev.studio.Jupiter.service.model

import com.google.gson.annotations.SerializedName

data class RoverManifestRemoteModel(

    @SerializedName("photo_manifest")
    val photoManifestRemoteModel: PhotoManifestRemoteModel
)

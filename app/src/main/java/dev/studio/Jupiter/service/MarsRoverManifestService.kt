package dev.studio.Jupiter.service

import dev.studio.Jupiter.domain.model.RoverUiModel
import dev.studio.Jupiter.service.model.RoverManifestRemoteModel
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import retrofit2.http.Path
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

interface MarsRoverManifestService {
    @GET("mars-photos/api/manifest/{rover_name}?api_key=DEMO_KEY")
    suspend fun getMarsRoverManifest(@Path("rover_name") roverNAme: String): RoverManifestRemoteModel

    companion object {
        private const val BASE_URL = "https://api.nasa.gov/"
        fun create(): MarsRoverManifestService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MarsRoverManifestService::class.java)
        }
    }
}
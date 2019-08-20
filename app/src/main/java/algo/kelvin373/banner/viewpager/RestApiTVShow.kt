package algo.kelvin373.banner.viewpager

import io.reactivex.Observable
import retrofit2.http.GET

interface RestApiTVShow {

    @GET("/3/tv/airing_today?api_key=${BuildConfig.API_KEY}&language=en-US")
    fun getDataTVShowAiringToday() : Observable<TVShow>

}
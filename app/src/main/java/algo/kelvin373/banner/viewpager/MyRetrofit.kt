package algo.kelvin373.banner.viewpager

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {

    fun iniRetrofitTVShow(): RestApiTVShow {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.URL_MOVIE_CATALOG)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RestApiTVShow::class.java)
    }
}
package sample.base.app.data.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import sample.base.app.data.model.FiveDayWeatherResponse
import sample.base.app.data.model.NewsResponse
import sample.base.app.data.model.WeatherResponse

interface AppService {

    @GET("top-headlines")
    fun getTopHeadLines(@Query("country") country : String,
                        @Query("page") page : Int,
                        @Query("apiKey") apiKey : String) : Observable<NewsResponse>


    @GET("data/2.5/weather")
    fun getWeatherByZip(@Query("zip") zip: String,
                         @Query("appid") appid: String) : Observable<WeatherResponse>

    @GET("data/2.5/forecast")
    fun getFiveDayWeather(@Query("zip") zip: String,
                        @Query("appid") appid: String) : Observable<FiveDayWeatherResponse>
}

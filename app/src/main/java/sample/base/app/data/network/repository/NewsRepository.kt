package sample.base.app.data.network.repository

import io.reactivex.Observable
import retrofit2.http.Query
import sample.base.app.data.model.FiveDayWeatherResponse
import sample.base.app.data.model.NewsResponse
import sample.base.app.data.model.WeatherResponse
import sample.base.app.data.network.AppService
import sample.base.app.utils.Network

interface NewsRepository {
    fun getNews() : Observable<NewsResponse>

    fun getWeather(zip: String,
                   appid: String) : Observable<WeatherResponse>

    fun getWeatherLastFive(zip: String,
                   appid: String) : Observable<FiveDayWeatherResponse>

}

class NewsRepositoryImpl (private val appService: AppService) : NewsRepository {

    override fun getWeatherLastFive(
        zip: String,
        appid: String
    ): Observable<FiveDayWeatherResponse> = appService.getFiveDayWeather(zip, appid)


    override fun getWeather(zip: String,
                            appid: String): Observable<WeatherResponse> = appService.getWeatherByZip(zip, appid)

    override fun getNews() : Observable<NewsResponse> =
        appService.getTopHeadLines("us", 1, Network.API_KEY)
}
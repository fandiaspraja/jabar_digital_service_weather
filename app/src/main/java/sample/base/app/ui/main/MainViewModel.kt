package sample.base.app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import sample.base.app.base.BaseViewModel
import sample.base.app.data.model.Article
import sample.base.app.data.model.FiveDayWeatherResponse
import sample.base.app.data.model.WeatherResponse
import sample.base.app.data.network.repository.NewsRepository
import sample.base.app.utils.Network
import sample.base.app.utils.ext.with
import sample.base.app.utils.rx.SchedulerProvider

class MainViewModel(
    private val repo: NewsRepository,
    private val scheduler: SchedulerProvider
) : BaseViewModel() {

    private val dataNews = MutableLiveData<List<Article>>()

    val mDataNews: LiveData<List<Article>>
        get() = dataNews

    private val dataWeather = MutableLiveData<WeatherResponse>()

    val mDataWeather: LiveData<WeatherResponse>
        get() = dataWeather

    private val dataWeatherFiveDay = MutableLiveData<FiveDayWeatherResponse>()

    val mDataWeatherFiveDay: LiveData<FiveDayWeatherResponse>
        get() = dataWeatherFiveDay

//    init {
//        getWeather("41284, id", Network.API_KEY)
//        getWeatherFiveDay("41284, id", Network.API_KEY)
//
//    }

    fun getNews() {
        launch {
            isLoading.set(true)
            repo.getNews().with(scheduler).subscribe(
                {
                    isLoading.set(false)
                    dataNews.value = it.articles
                },
                { err ->
                    isLoading.set(false)
                    showMessage.value = handleError(err)
                })
        }
    }

    fun getWeather(zip: String,
                   appid: String) {
        launch {
            isLoading.set(true)
            repo.getWeather(zip, appid).with(scheduler).subscribe(
                {
                    isLoading.set(false)
                    dataWeather.value = it
                },
                { err ->
                    isLoading.set(false)
                    showMessage.value = handleError(err)
                })
        }
    }

    fun getWeatherFiveDay(zip: String,
                   appid: String) {
        launch {
            isLoading.set(true)
            repo.getWeatherLastFive(zip, appid).with(scheduler).subscribe(
                {
                    isLoading.set(false)
                        dataWeatherFiveDay.value = it
                },
                { err ->
                    isLoading.set(false)
                    showMessage.value = handleError(err)
                })
        }
    }
}
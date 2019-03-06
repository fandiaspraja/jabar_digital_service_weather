package sample.base.app.data.network.repository

import io.reactivex.Observable
import sample.base.app.data.model.NewsResponse
import sample.base.app.data.network.AppService

class Repository (private val appService: AppService) {

    fun getNews() : Observable<NewsResponse> =
        appService.getTopHeadLines("us", 1)
}
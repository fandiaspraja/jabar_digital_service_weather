package sample.base.app.ui.main

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import sample.base.app.BR
import sample.base.app.R
import sample.base.app.base.BaseActivity
import sample.base.app.databinding.ActivityMainBinding
import android.content.Intent
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import sample.base.app.utils.Network


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getBindingVariable(): Int = BR.viewModel
    override fun getVM(): MainViewModel = getViewModel()
    override fun getLayoutId(): Int = R.layout.activity_main

    lateinit var name: String
    lateinit var zipCode: String

    override fun letStart() {

        val intent = intent

        name = intent.getStringExtra("name")
        zipCode = intent.getStringExtra("postalcode")

        mViewModel.getWeather(zipCode + ",id", Network.API_KEY)
        mViewModel.getWeatherFiveDay(zipCode + ",id", Network.API_KEY)

        initData()
        observeDataWeather()
        observeDataWeatherFiveDay()
    }

    private lateinit var mainAdapter: MainAdapter

    fun observeData() {
        mViewModel.mDataNews.observe(this, Observer { resource ->
            resource?.let {
//                mainAdapter.items = it
//                mainAdapter.notifyDataSetChanged()
            }
        })
    }

    fun observeDataWeatherFiveDay() {
        mViewModel.mDataWeatherFiveDay.observe(this, Observer { resource ->
            resource?.let {
                mainAdapter.items = it.list
            }
        })
    }

    fun observeDataWeather() {
        mViewModel.mDataWeather.observe(this, Observer { resource ->
            resource?.let {
                temp.text = it.main.temp.toString()
            }
        })
    }

    fun initData() {
        et_name.text = name
        mainAdapter = MainAdapter(listOf())
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = mainAdapter
    }
}
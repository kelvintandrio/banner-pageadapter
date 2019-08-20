package algo.kelvin373.banner.viewpager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TVShowRepository : TVShowInter {
    private val apiService = MyRetrofit.iniRetrofitTVShow()

    override fun getTVShowAiringToday(disposable: CompositeDisposable, statusResponseTVShow: StatusResponseTVShow): LiveData<List<DataTVShow>> {
        val myTVShowAiringToday = MutableLiveData<List<DataTVShow>>()
        disposable.add(
            apiService.getDataTVShowAiringToday()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.dataTVShow?.take(5) }
                .subscribe(
                    {
                        statusResponseTVShow.onSuccess(it!!)
                        myTVShowAiringToday.postValue(it)
                    },
                    {
                        statusResponseTVShow.onFailed()
                    }
                ))
        return myTVShowAiringToday
    }
}
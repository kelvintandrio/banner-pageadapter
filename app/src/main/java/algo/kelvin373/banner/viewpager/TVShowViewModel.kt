package algo.kelvin373.banner.viewpager

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class TVShowViewModel(private val tvShowRepository: TVShowRepository,
                      private val compositeDisposable: CompositeDisposable) : ViewModel() {
    private val myDataTVShowAiringToday = MutableLiveData<List<DataTVShow>>()

    fun getDataTVShowAiringToday() : LiveData<List<DataTVShow>> {
        tvShowRepository.getTVShowAiringToday(compositeDisposable, object : StatusResponseTVShow {
            override fun onSuccess(list: List<DataTVShow>) = myDataTVShowAiringToday.postValue(list)
            override fun onFailed() {
                Log.i("TES", "Failed")
            }
        })
        return myDataTVShowAiringToday
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
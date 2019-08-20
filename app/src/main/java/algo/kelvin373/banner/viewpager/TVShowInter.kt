package algo.kelvin373.banner.viewpager

import androidx.lifecycle.LiveData
import io.reactivex.disposables.CompositeDisposable

interface TVShowInter {
    fun getTVShowAiringToday(
        disposable: CompositeDisposable,
        statusResponseTVShow: StatusResponseTVShow
    ): LiveData<List<DataTVShow>>
}
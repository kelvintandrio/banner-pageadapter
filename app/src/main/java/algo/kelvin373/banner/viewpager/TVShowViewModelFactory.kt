package algo.kelvin373.banner.viewpager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.disposables.CompositeDisposable

class TVShowViewModelFactory(val tvShowRepository: TVShowRepository,
                             val compositeDisposable: CompositeDisposable) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>)
            : T = TVShowViewModel(tvShowRepository, compositeDisposable) as T
}
package algo.kelvin373.banner.viewpager

import algo.kelvin373.banner.banner_viewpager.setupPageBanner
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_banner.view.*

class MainActivity : AppCompatActivity() {

    private val tvShowViewModel by lazy {
        ViewModelProviders.of(this,
            TVShowViewModelFactory(tvShowRepository = TVShowRepository(), compositeDisposable = CompositeDisposable()))
            .get(TVShowViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvShowViewModel.getDataTVShowAiringToday().observe(this, Observer { data ->
            viewpager_tv_show_banner.setupPageBanner<DataTVShow>(R.layout.item_banner, this) {
                setBanner(data)
                banner {
                    val imageBanner = "${BuildConfig.URL_POSTER}${item?.backgroundTVShow}"
                    viewBanner.sample_title.text = item?.titleTVShow
                    Glide.with(this@MainActivity).load(imageBanner).into(viewBanner.sample_image)
                }
                setWormDotsIndicator(worm_dots_indicator_tv_show)
                autoSlideBanner(true)
            }
        })
    }
}

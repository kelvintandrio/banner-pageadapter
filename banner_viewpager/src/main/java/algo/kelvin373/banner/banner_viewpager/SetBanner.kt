package algo.kelvin373.banner.banner_viewpager

import android.content.Context
import android.os.Handler
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

@Suppress("UNCHECKED_CAST")
class SetBanner<T>(layout: Int, context: Context, private val viewPager: ViewPager) {
    var adapterBanner = PageBannerAdapter<T>(layout, context)

    fun banner(banner: Binding<T>.() -> Unit) {
        adapterBanner.setBanner(banner as Binding<*>.() -> Unit)
    }

    fun setBanner(list: List<T>?) {
        adapterBanner.addListBanner(list)
    }

    fun setWormDotsIndicator(wormDotsIndicator: WormDotsIndicator) {
        wormDotsIndicator.setViewPager(viewPager)
    }

    fun autoSlideBanner(boolean: Boolean) {
        if(boolean) {
            var state = 1
            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    viewPager.setCurrentItem(state, true)
                    state += 1
                    if (state == adapterBanner.count)
                        state = 0
                    handler.postDelayed(this, 5000)
                }
            }, 5000)
        }
    }

    init {
        viewPager.adapter = adapterBanner
    }
}
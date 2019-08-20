package algo.kelvin373.banner.banner_viewpager

import android.content.Context
import androidx.viewpager.widget.ViewPager

fun <T> ViewPager.setupPageBanner(layout: Int, context: Context, setBanner: SetBanner<T>.() -> Unit) {
    setBanner(SetBanner(layout, context, this))
}
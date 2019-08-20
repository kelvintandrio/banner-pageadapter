package algo.kelvin373.banner.banner_viewpager

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class PageBannerAdapter<T>(private val layoutBanner: Int, private val context: Context) : PagerAdapter() {

    private lateinit var setupBanner: Binding<*>.() -> Unit
    private var listBanner: MutableList<T> = mutableListOf()

    override fun isViewFromObject(view: View, o: Any): Boolean = view == o

    override fun getCount(): Int = listBanner.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater
            .from(context)
            .inflate(layoutBanner, container, false)
        bind(setupBanner, listBanner[position], view)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    private fun bind(setup: Binding<*>.() -> Unit, item: Any?, view: View)  {
        Log.i("Tes List Data", "You have process setup")
        setup(Binding(view, item))
    }

    fun addListBanner(list: List<T>?) {
        Log.i("Tes List Data", "You have been set list")
        if (list != null) {
            this.listBanner.addAll(list)
            Log.i("Tes List Data", "Total = ${list.size}")
        }
        notifyDataSetChanged()
    }

    fun setBanner(binding: Binding<*>.() -> Unit) {
        Log.i("Tes List Data", "Banner Called")
        this.setupBanner = binding
    }

}
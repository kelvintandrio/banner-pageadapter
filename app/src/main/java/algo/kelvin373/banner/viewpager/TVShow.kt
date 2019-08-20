package algo.kelvin373.banner.viewpager

import com.google.gson.annotations.SerializedName

data class TVShow(
    @field:SerializedName("results") val dataTVShow: ArrayList<DataTVShow>? = null
)

data class DataTVShow(
    @field:SerializedName("backdrop_path") val backgroundTVShow: String? = null,
    @field:SerializedName("name") val titleTVShow: String? = null,
    @field:SerializedName("first_air_date") val firstDateTVShow: String? = null,
    @field:SerializedName("id") val idTVShow: Int? = null
)
package com.gg.echart
import com.google.gson.annotations.SerializedName


/**
 * Creator : GG
 * Date    : 2018/2/26
 * Mail    : gg.jin.yu@gmai.com
 * Explain :
 */

data class Bean(
		@SerializedName("legend") var legend: Legend? = Legend(),
		@SerializedName("series") var series: List<Sery?>? = listOf(),
		@SerializedName("title") var title: Title? = Title(),
		@SerializedName("tooltip") var tooltip: Tooltip? = Tooltip()
)

data class Title(
		@SerializedName("subtext") var subtext: String? = "", //纯属虚构
		@SerializedName("text") var text: String? = "", //某站点用户访问来源
		@SerializedName("x") var x: String? = "" //center
)

data class Legend(
		@SerializedName("data") var data: List<String?>? = listOf(),
		@SerializedName(" left") var left: String? = "", //left
		@SerializedName("orient") var orient: String? = "" //vertical
)

data class Tooltip(
		@SerializedName(" formatter") var formatter: String? = "", //{a} <br/>{b} : {c} ({d}%)
		@SerializedName("trigger") var trigger: String? = "" //item
)

data class Sery(
		@SerializedName("center") var center: List<String?>? = listOf(),
		@SerializedName("data") var data: List<Data?>? = listOf(),
		@SerializedName("itemStyle") var itemStyle: ItemStyle? = ItemStyle(),
		@SerializedName(" name") var name: String? = "", //访问来源
		@SerializedName(" radius ") var radius: String? = "", //55%
		@SerializedName(" type") var type: String? = "" //pie
)

data class Data(
		@SerializedName("name") var name: String? = "", //直接访问
		@SerializedName("value") var value: Int? = 0 //335
)

data class ItemStyle(
		@SerializedName(" emphasis") var emphasis: Emphasis? = Emphasis()
)

data class Emphasis(
		@SerializedName(" shadowBlur") var shadowBlur: Int? = 0, //10
		@SerializedName("shadowColor") var shadowColor: String? = "", //rgba(0, 0, 0, 0.5)
		@SerializedName("shadowOffsetX") var shadowOffsetX: Int? = 0 //0
)
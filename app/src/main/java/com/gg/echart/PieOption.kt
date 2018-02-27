package com.gg.echart

import com.google.gson.annotations.SerializedName


/**
 * Creator : GG
 * Date    : 2018/2/26
 * Mail    : gg.jin.yu@gmai.com
 * Explain :
 */

data class PieOption(
		@SerializedName("title") var title: Title? = Title(),
		@SerializedName("tooltip") var tooltip: Tooltip? = Tooltip(),
		@SerializedName("legend") var legend: Legend? = Legend(),
		@SerializedName("series") var series: List<Series?>? = listOf()
) {
	data class Series(
			@SerializedName("name") var name: String? = "", //访问来源
			@SerializedName("type") var type: String? = "", //pie
			@SerializedName("radius") var radius: String? = "", //55%
			@SerializedName("center") var center: List<String?>? = listOf(),
			@SerializedName("data") var data: List<Data?>? = listOf(),
			@SerializedName("itemStyle") var itemStyle: ItemStyle? = ItemStyle(),
			var label: Label? = Label()
	) {
		data class Data(
				@SerializedName("value") var value: Any? = 0f, //335
				@SerializedName("name") var name: String? = "" //直接访问
		)

		data class ItemStyle(
				@SerializedName("emphasis") var emphasis: Emphasis? = Emphasis()
		) {
			data class Emphasis(
					@SerializedName("shadowBlur") var shadowBlur: Int? = 0, //10
					@SerializedName("shadowOffsetX") var shadowOffsetX: Int? = 0, //0
					@SerializedName("shadowColor") var shadowColor: String? = "" //rgba(0, 0, 0 0.5)
			)
		}

		data class Label(var fontSize: Int? = 30, val position: String? = "outside")
	}

	data class Tooltip(
			@SerializedName("trigger") var trigger: String? = "", //item
			@SerializedName("formatter") var formatter: String? = "", //{a} <br/>{b} : {c} ({d}%)
			var textStyle: TextStyle? = TextStyle()
	) {
		data class TextStyle(var fontStyle: String = "normal", var fontSize: Int = 27)
	}

	data class Legend(
			@SerializedName("orient") var orient: String? = "", //vertical
			@SerializedName("left") var left: String? = "", //left
			@SerializedName("data") var data: List<String?>? = listOf(),
			var textStyle: TextStyle? = TextStyle(),
			var top: Int? = 20
	) {
		data class TextStyle(var fontStyle: String = "normal", var fontSize: Int = 30)
	}

	data class Title(
			@SerializedName("text") var text: String? = "", //某站点用户访问来源
			@SerializedName("subtext") var subtext: String? = "", //纯属虚构
			@SerializedName("x") var x: String? = "center",//center
			var textStyle: TextStyle? = TextStyle(),
			var padding: List<Int>? = listOf(5, 5, 5, 5)
	) {
		data class TextStyle(var fontStyle: String = "normal", var fontSize: Int = 40)
	}
}
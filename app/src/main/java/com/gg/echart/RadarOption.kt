package com.gg.echart
import com.google.gson.annotations.SerializedName


/**
 * Creator : GG
 * Date    : 2018/2/26
 * Mail    : gg.jin.yu@gmai.com
 * Explain :
 */


data class RadarOption(
		@SerializedName("title") var title: Title? = Title(),
		@SerializedName("tooltip") var tooltip: Tooltip? = Tooltip(),
		@SerializedName("legend") var legend: Legend? = Legend(),
		@SerializedName("radar") var radar: Radar? = Radar(),
		@SerializedName("series") var series: List<Series?>? = listOf()
) {
	data class Tooltip(
			@SerializedName("trigger") var trigger: String? = null, //item
			@SerializedName("formatter") var formatter: String? = null, //{a} <br/>{b} : {c} ({d}%)
			var textStyle: TextStyle? = TextStyle()
	){
		data class TextStyle(var fontStyle: String = "normal", var fontSize: Int = 27)
	}

	data class Legend(
			@SerializedName("data") var data: List<String?>? = listOf()
	)

	data class Series(
			@SerializedName("name") var name: String? = "", //预算 vs 开销（Budget vs spending）
			@SerializedName("type") var type: String? = "", //radar
			@SerializedName("data") var data: List<Data?>? = listOf(),
			var label: Label? = Label()

	) {
		data class Data(
				@SerializedName("value") var value: List<Any?>? = listOf(),
				@SerializedName("name") var name: String? = "" //预算分配（Allocated Budget）
		)
		data class Label(var fontSize: Int? = 30)

	}

	data class Radar(
			@SerializedName("name") var name: Name? = Name(),
			@SerializedName("indicator") var indicator: List<Indicator?>? = listOf()
	) {
		data class Name(
				@SerializedName("textStyle") var textStyle: TextStyle? = TextStyle()
		) {
			data class TextStyle(
					@SerializedName("color") var color: String? = "", //#fff
					@SerializedName("backgroundColor") var backgroundColor: String? = "", //#999
					@SerializedName("borderRadius") var borderRadius: Int? = 0, //3
					@SerializedName("padding") var padding: List<Int?>? = listOf()
			)
		}
		data class Indicator(
				@SerializedName("name") var name: String? = "", //销售（sales）
				@SerializedName("max") var max: Int? = 0 //6500
		)
	}

	data class Title(
			@SerializedName("text") var text: String? = "" //基础雷达图
	)
}

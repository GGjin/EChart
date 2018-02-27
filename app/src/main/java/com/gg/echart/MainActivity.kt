package com.gg.echart

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bean = PieOption(title = PieOption.Title(text = "某站点用户访问来源", subtext = "纯属虚构", x = "center",textStyle = PieOption.Title.TextStyle(fontSize = 20)),
                tooltip = PieOption.Tooltip(trigger = "item", formatter = "{a} <br/>{b} : {c} ({d}%)", textStyle = PieOption.Tooltip.TextStyle(fontSize = 10)),
                legend = PieOption.Legend(orient = "vertical", left = "left", data = listOf("直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎"),textStyle = PieOption.Legend.TextStyle(fontSize = 15)),
                series = listOf(PieOption.Series(name = "访问来源", type = "pie", radius = "55%", center = listOf("50%", "60%"),
                        label = PieOption.Series.Label(fontSize = 10),
                        data = listOf(
                        PieOption.Series.Data(value = 335, name = "直接访问"),
                        PieOption.Series.Data(value = 310, name = "邮件营销"),
                        PieOption.Series.Data(value = 234, name = "联盟广告"),
                        PieOption.Series.Data(value = 135, name = "视频广告"),
                        PieOption.Series.Data(value = 1548, name = "搜索引擎")
                ), itemStyle = PieOption.Series.ItemStyle(emphasis = PieOption.Series.ItemStyle.Emphasis(shadowBlur = 10, shadowOffsetX = 0, shadowColor = "rgba(0, 0, 0, 0.5)"))))
        )

        val radar = RadarOption(title = RadarOption.Title(text = "基础雷达图"),
                legend = RadarOption.Legend(data = listOf("预算分配（Allocated Budget）", "实际开销（Actual Spending）")),
                radar = RadarOption.Radar(name = RadarOption.Radar.Name(textStyle = RadarOption.Radar.Name.TextStyle(color = "#fff", backgroundColor = "#999", borderRadius = 3, padding = listOf(3, 5))), indicator = listOf(
                        RadarOption.Radar.Indicator(name = "销售（sales）", max = 6500),
                        RadarOption.Radar.Indicator(name = "管理（Administration）", max = 16000),
                        RadarOption.Radar.Indicator(name = "信息技术（Information Techology）", max = 30000),
                        RadarOption.Radar.Indicator(name = "客服（Customer Support）", max = 38000),
                        RadarOption.Radar.Indicator(name = "研发（Development）", max = 52000),
                        RadarOption.Radar.Indicator(name = "市场（Marketing", max = 25000)
                )),
                series = listOf(RadarOption.Series(name = "预算 vs 开销（Budget vs spending）", type = "radar", data = listOf(RadarOption.Series.Data(value = listOf(4300.0, 10000.0, 28000.0, 35000.0, 50000.0, 19000.0), name = "预算分配（Allocated Budget）"), RadarOption.Series.Data(value = listOf(5000, 14000, 28000, 31000, 42000, 21000), name = "实际开销（Actual Spending）"))))
        )

        Log.w("bean", Gson().toJson(bean))
        //进行webwiev的一堆设置
        webView.settings.allowFileAccess = true
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/echarts.html")
        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView, url: String) {
                //最好在这里调用js代码 以免网页未加载完成
                Log.w("bean", Gson().toJson(bean))
                Log.w("radar", Gson().toJson(radar))
                webView.loadUrl("javascript:createChart(" + Gson().toJson(bean) + ");")
            }
        }
    }
}

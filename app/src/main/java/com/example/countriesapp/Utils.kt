package com.example.countriesapp

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import java.text.NumberFormat
import java.util.*

fun languagesToString(languages: List<Language>) : String {
    /*var result = ""

    for ((index, language) in languages.withIndex())
        if (index != languages.lastIndex)
            result += "${language.name}, "
        else
            result += language.name

    return result*/

    return languages.joinToString { it.name }
}

fun formatNumber(number: Long) : String {
    val string = NumberFormat.getInstance().format(number)

    return string
}

suspend fun loadSvg(imageView: ImageView, url: String) {
    if (url.lowercase(Locale.ENGLISH).endsWith("svg")) {
        val imageLoader = ImageLoader.Builder(imageView.context)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
        val request: ImageRequest = ImageRequest.Builder(imageView.context)
            .data(url)
            .target(imageView)
            .build()
        imageLoader.execute(request)
    } else {
        imageView.load(url)
    }
}
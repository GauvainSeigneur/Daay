package com.gauvain.seigneur.data.mapper

import com.gauvain.seigneur.domain.models.Color

class ColorMapper {

    fun map(hexColor: String): Color {
        val (red, green, blue, alpha) = hexColor
            .removePrefix("#")
            .chunked(2)
            .map { it.toInt(16) }

        return Color(
            red = red,
            green = green,
            blue = blue,
            alpha = alpha,
        )
    }
}
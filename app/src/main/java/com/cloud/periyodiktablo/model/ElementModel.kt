package com.cloud.periyodiktablo.model

import android.graphics.Color

data class ElementModel(val name: String, val symbol: String, val number : String, val summary : String, val imageUrl : String, val group : String, val isVisible : Boolean = true) {
    constructor() : this("","","","","","",false)
    var color = 0
    init {
        color = when(group){
            "alkali metal" -> Color.parseColor("#CE332D")
            "alkaline earth" -> Color.parseColor("#F7A700")
            "transition metal" -> Color.parseColor("#FFEF1D")
            "basic metal" -> Color.parseColor("#ABC90A")
            "metalloid" -> Color.parseColor("#24A637")
            "nonmetal" -> Color.parseColor("#2ABDEF")
            "halogen" -> Color.parseColor("#009FDF")
            "noble gas" -> Color.parseColor("#B477B1")
            "lanthanide" -> Color.parseColor("#E8368D")
            "actinide" -> Color.parseColor("#EC61A0")
            else -> 0
        }
    }
}
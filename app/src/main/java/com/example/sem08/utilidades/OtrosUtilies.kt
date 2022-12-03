package com.example.sem08.utilidades

import java.text.SimpleDateFormat
import java.util.*

class OtrosUtilies {
    companion object{
        fun getTempFile(prefijo:String): String{
            val nombre = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            return prefijo+nombre
        }
    }
}
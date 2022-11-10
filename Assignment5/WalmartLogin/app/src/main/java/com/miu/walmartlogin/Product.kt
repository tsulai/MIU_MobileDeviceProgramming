package com.miu.walmartlogin

import android.icu.text.CaseMap
import java.io.Serializable

data class Product (var title: String, var price: Double, var color: String, var img: String, var itemId: String, var desc: String) :
    Serializable
//Serializable ပါမှ adapter class ထဲမှာ intent မှာ object pass လို့ရ
// intent.putExtra("product", plist[position])
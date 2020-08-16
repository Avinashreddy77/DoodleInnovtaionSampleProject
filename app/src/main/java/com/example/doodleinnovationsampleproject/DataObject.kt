package com.example.doodleinnovationsampleproject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DataObject (
    var itemName : String = "",
    var itemSubName : String = "",
    var itemCount :  String = ""
) : Parcelable
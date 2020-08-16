package com.example.doodleinnovationsampleproject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class UserCartData (
    var userCartItemName : String = "",
    var userCartItemSubName : String = "",
    var userCartItemCount :  String = ""
) : Parcelable
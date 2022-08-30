package com.unknown.onepointtest.data.remote.response

import com.google.gson.annotations.SerializedName
import com.unknown.onepointtest.domain.Tree

data class TreeResponse(
    @SerializedName("idbase")
    val id: Long,
    @SerializedName("libellefrancais")
    val nom : String,
    @SerializedName("espece")
    val espece : String,
    @SerializedName("hauteurenm")
    val hauteur : Int,
    @SerializedName("circonferenceencm")
    val circonference : Int,
    @SerializedName("adresse")
    val adresse : String
)

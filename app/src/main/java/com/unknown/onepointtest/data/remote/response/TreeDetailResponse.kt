package com.unknown.onepointtest.data.remote.response

import com.google.gson.annotations.SerializedName

data class TreeDetailResponse(
    @SerializedName("record")
    val record: RecordResponse
)

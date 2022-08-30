package com.unknown.onepointtest.data.remote.response

import com.google.gson.annotations.SerializedName

data class TreeListResponse(
    @SerializedName("records")
    val records : List<RecordsResponse>
)

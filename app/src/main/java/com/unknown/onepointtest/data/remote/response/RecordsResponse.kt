package com.unknown.onepointtest.data.remote.response

import com.google.gson.annotations.SerializedName

data class RecordsResponse(
    @SerializedName("record")
    val records: RecordResponse
)

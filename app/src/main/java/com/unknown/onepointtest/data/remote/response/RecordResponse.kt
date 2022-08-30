package com.unknown.onepointtest.data.remote.response

import com.google.gson.annotations.SerializedName
import com.unknown.onepointtest.domain.Tree

data class RecordResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("fields")
    val tree : TreeResponse
)


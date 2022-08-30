package com.unknown.onepointtest.domain

data class Tree private constructor(
    val id: String,
    val name: String,
    val espece: String,
    val hauteur : Int,
    val circonference: Int,
    val adresse : String
        )
{
    companion object {
        operator fun invoke(id: String?, name: String?, espece: String?, hauteur : Int?, circonference: Int?,adresse: String?) : Tree{
            require(id != null && id.isNotBlank() && id.isNotEmpty())
            return Tree(id, validateString(name), validateString(espece), hauteur?: 0, circonference?: 0, validateString(adresse))
        }
    }
}

private fun validateString(str: String?) : String {
    if(str.isNullOrBlank() || str.equals("n. sp.")) {
        return "N/A"
    }
    return str
}
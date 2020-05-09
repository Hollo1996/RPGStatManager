package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class S_Tool (
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("name")
    var name: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("moves")
    var moves: List<S_Move> = ArrayList()
){
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val tool =
            other as S_Tool
        return id == tool.id &&
                name == tool.name &&
                moves == tool.moves
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, moves)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Tool {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    moves: ").append(toIndentedString(moves)).append("\n")
        sb.append("}")
        return sb.toString()
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private fun toIndentedString(o: Any?): String {
        return o?.toString()?.replace("\n", "\n    ") ?: "null"
    }
}
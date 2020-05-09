package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class S_Stat (
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("half")
    var half: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("line")
    var line: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("value")
    var value: Long? = null
){
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val stat = other as S_Stat
        return id == stat.id &&
                half == stat.half &&
                line == stat.line &&
                value == stat.value
    }

    override fun hashCode(): Int {
        return Objects.hash(id, half, line, value)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Stat {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    half: ").append(toIndentedString(half)).append("\n")
        sb.append("    line: ").append(toIndentedString(line)).append("\n")
        sb.append("    value: ").append(toIndentedString(value)).append("\n")
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
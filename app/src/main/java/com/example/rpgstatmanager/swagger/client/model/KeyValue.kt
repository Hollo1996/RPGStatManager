package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class KeyValue (
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("key")
    var key: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("value")
    var value: Long? = null
){
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val keyValue =
            o as KeyValue
        return key == keyValue.key &&
                value == keyValue.value
    }

    override fun hashCode(): Int {
        return Objects.hash(key, value)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class KeyValue {\n")
        sb.append("    key: ").append(toIndentedString(key)).append("\n")
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
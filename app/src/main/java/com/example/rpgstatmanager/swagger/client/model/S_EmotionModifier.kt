package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class S_EmotionModifier (
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
    @SerializedName("trigger")
    var trigger: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("values")
    var values: List<S_KeyValue> =
        ArrayList()
){
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val emotionModifier = other as S_EmotionModifier
        return id == emotionModifier.id &&
                name == emotionModifier.name &&
                trigger == emotionModifier.trigger &&
                values == emotionModifier.values
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, trigger, values)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class EmotionModifier {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n")
        sb.append("    values: ").append(toIndentedString(values)).append("\n")
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
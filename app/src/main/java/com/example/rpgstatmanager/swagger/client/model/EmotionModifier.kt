package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class EmotionModifier (
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
    var values: List<KeyValue> =
        ArrayList()
){
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val emotionModifier = o as EmotionModifier
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
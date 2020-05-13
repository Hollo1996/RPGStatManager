package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class S_Adventure (
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id : String,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("name")
    var name: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("is_gm")
    var isGm: Boolean? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("icon")
    var icon: String? = null
){
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val adventure = other as S_Adventure
        return id == adventure.id &&
                name == adventure.name &&
                isGm == adventure.isGm &&
                icon == adventure.icon
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, isGm, icon)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Adventure {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    isGm: ").append(toIndentedString(isGm)).append("\n")
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n")
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
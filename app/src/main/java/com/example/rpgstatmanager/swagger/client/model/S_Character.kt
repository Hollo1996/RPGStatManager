package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class S_Character (
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id: String,
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var adventureId: String,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("name")
    var name: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("is_npc")
    var isNpc: Boolean? = null){

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val character =
            other as S_Character
        return id == character.id &&
                name == character.name &&
                isNpc == character.isNpc
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, isNpc)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Character {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    isNpc: ").append(toIndentedString(isNpc)).append("\n")
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
package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class Move (
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("move_type_id")
    var moveTypeId: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("name")
    var name: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("cardRestriction")
    var cardRestriction: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("description")
    var description: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("effect")
    var effect: String? = null
){
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val move = o as Move
        return id == move.id &&
                moveTypeId == move.moveTypeId &&
                name == move.name &&
                cardRestriction == move.cardRestriction &&
                description == move.description &&
                effect == move.effect
    }

    override fun hashCode(): Int {
        return Objects.hash(id, moveTypeId, name, cardRestriction, description, effect)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Move {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    moveTypeId: ").append(toIndentedString(moveTypeId)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    cardRestriction: ").append(toIndentedString(cardRestriction)).append("\n")
        sb.append("    description: ").append(toIndentedString(description)).append("\n")
        sb.append("    effect: ").append(toIndentedString(effect)).append("\n")
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
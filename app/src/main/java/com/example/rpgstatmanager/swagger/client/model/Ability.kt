package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class Ability (
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("race_id")
    var raceId: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("name")
    var name: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("positive")
    var positive: Boolean? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("description")
    var description: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("effect")
    var effect: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("moves")
    var moves: List<Move> = ArrayList()
){
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val ability = o as Ability
        return id == ability.id &&
                raceId == ability.raceId &&
                name == ability.name &&
                positive == ability.positive &&
                description == ability.description &&
                effect == ability.effect &&
                moves == ability.moves
    }

    override fun hashCode(): Int {
        return Objects.hash(id, raceId, name, positive, description, effect, moves)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Ability {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    raceId: ").append(toIndentedString(raceId)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    positive: ").append(toIndentedString(positive)).append("\n")
        sb.append("    description: ").append(toIndentedString(description)).append("\n")
        sb.append("    effect: ").append(toIndentedString(effect)).append("\n")
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
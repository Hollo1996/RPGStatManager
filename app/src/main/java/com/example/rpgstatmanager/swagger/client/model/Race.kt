package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class Race (
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("categoryName")
    var categoryName: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("familyName")
    var familyName: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("raceName")
    var raceName: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("subraceName")
    var subraceName: String? = null
){
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val race = o as Race
        return id == race.id &&
                categoryName == race.categoryName &&
                familyName == race.familyName &&
                raceName == race.raceName &&
                subraceName == race.subraceName
    }

    override fun hashCode(): Int {
        return Objects.hash(id, categoryName, familyName, raceName, subraceName)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Race {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n")
        sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n")
        sb.append("    raceName: ").append(toIndentedString(raceName)).append("\n")
        sb.append("    subraceName: ").append(toIndentedString(subraceName)).append("\n")
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
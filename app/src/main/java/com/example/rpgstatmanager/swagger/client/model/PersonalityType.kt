package com.example.rpgstatmanager.swagger.client.model

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.util.*

@ApiModel(description = "")
data class PersonalityType (
    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("id")
    var id: String? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("introvert")
    var introvert: Long? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("extrovert")
    var extrovert: Long? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("observant")
    var observant: Long? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("intuitive")
    var intuitive: Long? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("thinking")
    var thinking: Long? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("feeling")
    var feeling: Long? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("judging")
    var judging: Long? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("prospecting")
    var prospecting: Long? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("assertive")
    var assertive: Long? = null,

    /**
     */
    @get:ApiModelProperty(value = "")
    @SerializedName("turbulent")
    var turbulent: Long? = null
){

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val personalityType = o as PersonalityType
        return id == personalityType.id &&
                introvert == personalityType.introvert &&
                extrovert == personalityType.extrovert &&
                observant == personalityType.observant &&
                intuitive == personalityType.intuitive &&
                thinking == personalityType.thinking &&
                feeling == personalityType.feeling &&
                judging == personalityType.judging &&
                prospecting == personalityType.prospecting &&
                assertive == personalityType.assertive &&
                turbulent == personalityType.turbulent
    }

    override fun hashCode(): Int {
        return Objects.hash(
            id,
            introvert,
            extrovert,
            observant,
            intuitive,
            thinking,
            feeling,
            judging,
            prospecting,
            assertive,
            turbulent
        )
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class PersonalityType {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    introvert: ").append(toIndentedString(introvert)).append("\n")
        sb.append("    extrovert: ").append(toIndentedString(extrovert)).append("\n")
        sb.append("    observant: ").append(toIndentedString(observant)).append("\n")
        sb.append("    intuitive: ").append(toIndentedString(intuitive)).append("\n")
        sb.append("    thinking: ").append(toIndentedString(thinking)).append("\n")
        sb.append("    feeling: ").append(toIndentedString(feeling)).append("\n")
        sb.append("    judging: ").append(toIndentedString(judging)).append("\n")
        sb.append("    prospecting: ").append(toIndentedString(prospecting)).append("\n")
        sb.append("    assertive: ").append(toIndentedString(assertive)).append("\n")
        sb.append("    turbulent: ").append(toIndentedString(turbulent)).append("\n")
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
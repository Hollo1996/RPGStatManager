package com.example.rpgstatmanager.swagger.client.api

import com.example.rpgstatmanager.swagger.client.model.*
import retrofit2.Call
import retrofit2.http.*

interface DataApi {
    /**
     * Get all abilities.
     * Returnes all abilities of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><Ability>>
    </Ability> */
    @GET("data/ability/{token}")
    fun listAbilities(
        @Path("token") token: String?, @Body body: S_Race?
    ): Call<List<S_Ability>>

    /**
     * update existing ability
     * Updates a newly created ability
     * @param token Authentication number
     * @param body the ability with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/ability/{token}")
    fun updateAbility(
        @Path("token") token: String?, @Body body: S_Ability?
    ): Call<Void>

    /**
     * add new ability
     * Uploads a newly created ability
     * @param token Authentication number
     * @param body the uploaded ability
     * @return Call<Void>
    </Void> */
    @POST("data/ability/{token}")
    fun createAbility(
        @Path("token") token: String?, @Body body: S_Ability?
    ): Call<Void>

    /**
     * delete existing ability
     * Deletes an ability given by id
     * @param token Authentication number
     * @param body the id of the ability to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/ability/{token}")
    fun deleteAbility(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all adventures.
     * Returnes all adventures of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><Adventure>>
    </Adventure> */
    @GET("data/adventure/{token}")
    fun listAdventures(
        @Path("token") token: String?, @Body body: S_Adventure?
    ): Call<List<S_Adventure>>

    /**
     * update existing adventure
     * Updates a newly created adventure
     * @param token Authentication number
     * @param body the adventure with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/adventure/{token}")
    fun updateAdventure(
        @Path("token") token: String?, @Body body: S_Adventure?
    ): Call<Void>

    /**
     * add new adventure
     * Uploades a newly created adventure
     * @param token Authentication number
     * @param body the uploaded adventure
     * @return Call<Void>
    </Void> */
    @POST("data/adventure/{token}")
    fun createAdventure(
        @Path("token") token: String?, @Body body: S_Adventure?
    ): Call<Void>

    /**
     * delete existing adventure
     * Deletes an adventure given by id
     * @param token Authentication number
     * @param body the id of the adventure to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/adventure/{token}")
    fun deleteAdventure(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all characters.
     * Returnes all characters of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><Character>>
    </Character> */
    @GET("data/character/{token}")
    fun listCharacters(
        @Path("token") token: String?, @Body body: S_Adventure?
    ): Call<List<S_Character>>

    /**
     * update existing character
     * Updates a newly created character
     * @param token Authentication number
     * @param body the character with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/character/{token}")
    fun updateCharacter(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<Void>

    /**
     * add new character
     * Uploads a newly created character
     * @param token Authentication number
     * @param body the uploaded character
     * @return Call<Void>
    </Void> */
    @POST("data/character/{token}")
    fun createCharacter(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<Void>

    /**
     * delete existing character
     * Deletes an character given by id
     * @param token Authentication number
     * @param body the id of the character to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/character/{token}")
    fun deleteCharacter(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all emotion modifier.
     * Returnes all emotion modifier of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><EmotionModifier>>
    </EmotionModifier> */
    @GET("data/emotionModifier/{token}")
    fun listEmotionModifiers(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<List<S_EmotionModifier>>

    /**
     * update existing emotion modifier
     * Updates a newly created emotion modifier
     * @param token Authentication number
     * @param body the emotion modifier with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/emotionModifier/{token}")
    fun updateEmotionModifier(
        @Path("token") token: String?,
        @Body body: S_EmotionModifier?
    ): Call<Void>

    /**
     * add new emotion modifier
     * Uploads a newly created emotion modifier
     * @param token Authentication number
     * @param body the uploaded emotion modifier
     * @return Call<Void>
    </Void> */
    @POST("data/emotionModifier/{token}")
    fun createEmotionModifier(
        @Path("token") token: String?,
        @Body body: S_EmotionModifier?
    ): Call<Void>

    /**
     * delete existing emotion modifier
     * Deletes an emotion modifier given by id
     * @param token Authentication number
     * @param body the id of the emotion modifier to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/emotionModifier/{token}")
    fun deleteEmotionModifier(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all moves.
     * Returnes all moves of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><Move>>
    </Move> */
    @GET("data/move/{token}")
    fun listMoves(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<List<S_Move>>

    /**
     * update existing move
     * Updates a newly created move
     * @param token Authentication number
     * @param body the move with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/move/{token}")
    fun updateMove(
        @Path("token") token: String?, @Body body: S_Move?
    ): Call<Void>

    /**
     * add new move
     * Uploads a newly created move
     * @param token Authentication number
     * @param body the uploaded move
     * @return Call<Void>
    </Void> */
    @POST("data/move/{token}")
    fun createMove(
        @Path("token") token: String?, @Body body: S_Move?
    ): Call<Void>

    /**
     * delete existing move
     * Deletes an move given by id
     * @param token Authentication number
     * @param body the id of the move to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/move/{token}")
    fun deleteMove(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all move type.
     * Returnes all all move type of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><MoveType>>
    </MoveType> */
    @GET("data/moveType/{token}")
    fun listMoveTypes(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<List<S_MoveType>>

    /**
     * update existing move type
     * Updates a newly created move type
     * @param token Authentication number
     * @param body the move type with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/moveType/{token}")
    fun updateMoveType(
        @Path("token") token: String?, @Body body: S_MoveType?
    ): Call<Void>

    /**
     * add new all move type
     * Uploads a newly created move type
     * @param token Authentication number
     * @param body the uploaded move type
     * @return Call<Void>
    </Void> */
    @POST("data/moveType/{token}")
    fun createMoveType(
        @Path("token") token: String?, @Body body: S_MoveType?
    ): Call<Void>

    /**
     * delete existing move type
     * Deletes an move type given by id
     * @param token Authentication number
     * @param body the id of the move type to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/moveType/{token}")
    fun deleteMoveType(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all personality type.
     * Returnes all personality type of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><PersonalityType>>
    </PersonalityType> */
    @GET("data/personalityType/{token}")
    fun listPersonalityType(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<List<S_PersonalityType>>

    /**
     * update existing personality type
     * Updates a newly created personality type
     * @param token Authentication number
     * @param body the personality type with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/personalityType/{token}")
    fun updatePersonalityType(
        @Path("token") token: String?,
        @Body body: S_PersonalityType?
    ): Call<Void>

    /**
     * add new personality type
     * Uploads a newly created personality type
     * @param token Authentication number
     * @param body the uploaded personality type
     * @return Call<Void>
    </Void> */
    @POST("data/personalityType/{token}")
    fun createPersonalityType(
        @Path("token") token: String?,
        @Body body: S_PersonalityType?
    ): Call<Void>

    /**
     * delete existing personality type
     * Deletes an personality type given by id
     * @param token Authentication number
     * @param body the id of the personality type to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/personalityType/{token}")
    fun deletePersonalityType(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all race.
     * Returnes all race of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><Race>>
    </Race> */
    @GET("data/race/{token}")
    fun listRaces(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<List<S_Race>>

    /**
     * update existing race
     * Updates a newly created race
     * @param token Authentication number
     * @param body the race with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/race/{token}")
    fun updateRace(
        @Path("token") token: String?, @Body body: S_Race?
    ): Call<Void>

    /**
     * add new race
     * Uploads a newly created race
     * @param token Authentication number
     * @param body the uploaded race
     * @return Call<Void>
    </Void> */
    @POST("data/race/{token}")
    fun createRace(
        @Path("token") token: String?, @Body body: S_Race?
    ): Call<Void>

    /**
     * delete existing race
     * Deletes an race given by id
     * @param token Authentication number
     * @param body the id of the race to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/race/{token}")
    fun deleteRace(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all stat.
     * Returnes all stat of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><Stat>>
    </Stat> */
    @GET("data/stat/{token}")
    fun listStat(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<List<S_Stat>>

    /**
     * update existing stat
     * Updates a newly created stat
     * @param token Authentication number
     * @param body the stat with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/stat/{token}")
    fun updateStat(
        @Path("token") token: String?, @Body body: S_Stat?
    ): Call<Void>

    /**
     * add new stat
     * Uploads a newly created stat
     * @param token Authentication number
     * @param body the uploaded stat
     * @return Call<Void>
    </Void> */
    @POST("data/stat/{token}")
    fun createStat(
        @Path("token") token: String?, @Body body: S_Stat?
    ): Call<Void>

    /**
     * delete existing stat
     * Deletes an stat given by id
     * @param token Authentication number
     * @param body the id of the stat to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/stat/{token}")
    fun deleteStat(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all row_item_tool.
     * Returnes all row_item_tool of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><Tool>>
    </Tool> */
    @GET("data/row_item_tool/{token}")
    fun listTool(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<List<S_Tool>>

    /**
     * update existing row_item_tool
     * Updates a newly created row_item_tool
     * @param token Authentication number
     * @param body the row_item_tool with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/row_item_tool/{token}")
    fun updateTool(
        @Path("token") token: String?, @Body body: S_Tool?
    ): Call<Void>

    /**
     * add new row_item_tool
     * Uploads a newly created row_item_tool
     * @param token Authentication number
     * @param body the uploaded row_item_tool
     * @return Call<Void>
    </Void> */
    @POST("data/row_item_tool/{token}")
    fun createTool(
        @Path("token") token: String?, @Body body: S_Tool?
    ): Call<Void>

    /**
     * delete row_item_tool
     * Deletes an row_item_tool given by id
     * @param token Authentication number
     * @param body the id of the row_item_tool to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/row_item_tool/{token}")
    fun deleteTool(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>

    /**
     * Get all row_item_weapon.
     * Returnes all row_item_weapon of the loged in user.
     * @param token Authentication number
     * @param body Owner object
     * @return Call<List></List><Weapon>>
    </Weapon> */
    @GET("data/row_item_weapon/{token}")
    fun listWeapon(
        @Path("token") token: String?, @Body body: S_Character?
    ): Call<List<S_Weapon>>

    /**
     * updateWeapon
     * Updates a newly created row_item_weapon
     * @param token Authentication number
     * @param body the row_item_weapon with updated parameters
     * @return Call<Void>
    </Void> */
    @PUT("data/row_item_weapon/{token}")
    fun updateWeapon(
        @Path("token") token: String?, @Body body: S_Weapon?
    ): Call<Void>

    /**
     * add new row_item_weapon
     * Uploads a newly created row_item_weapon
     * @param token Authentication number
     * @param body the uploaded row_item_weapon
     * @return Call<Void>
    </Void> */
    @POST("data/row_item_weapon/{token}")
    fun createWeapon(
        @Path("token") token: String?, @Body body: S_Weapon?
    ): Call<Void>

    /**
     * delete existing row_item_weapon
     * Deletes an row_item_weapon given by id
     * @param token Authentication number
     * @param body the id of the row_item_weapon to delete
     * @return Call<Void>
    </Void> */
    @DELETE("data/row_item_weapon/{token}")
    fun deleteWeapon(
        @Path("token") token: String?,
        @Body body: String?
    ): Call<Void>
}
/**
* RPG Stat Manager Central Server
* This is the server for the data accass of the RPG Users
*
* OpenAPI spec version: 1.0.0
* Contact: holloszaboakos.1996@gmail.com
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package com.example.rpgstatmanager.swagger.client.models

import com.example.rpgstatmanager.swagger.client.models.Move

/**
 * 
 * @param id 
 * @param name 
 * @param moves 
 */
data class Tool (
    val id: kotlin.String? = null,
    val name: kotlin.String? = null,
    val moves: kotlin.Array<Move>? = null
) {

}

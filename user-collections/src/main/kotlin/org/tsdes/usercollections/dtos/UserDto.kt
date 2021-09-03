package org.tsdes.usercollections.dtos

import io.swagger.annotations.ApiModelProperty

data class UserDto (

    @get:ApiModelProperty("The id of the user")
    var userId : String? = null,

    @get:ApiModelProperty("Amount of coins user has")
    var coins : Int? = null,

    @get:ApiModelProperty("How many (unopened) packs user has")
    var cardPacks : Int? = null,

    @get:ApiModelProperty("What cards user owns")
    var ownedCards : MutableList<CardCopyDto> = mutableListOf()
)
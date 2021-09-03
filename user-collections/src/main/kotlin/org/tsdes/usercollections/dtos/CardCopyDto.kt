package org.tsdes.usercollections.dtos

import io.swagger.annotations.ApiModelProperty

data class CardCopyDto (

    @get:ApiModelProperty("Id of the card")
    var cardId : String? = null,

    @get:ApiModelProperty("Owner")
    var user : UserDto? = null,

    @get:ApiModelProperty("Number of copies owned")
    var numberOfCopies : Int? = 0
)

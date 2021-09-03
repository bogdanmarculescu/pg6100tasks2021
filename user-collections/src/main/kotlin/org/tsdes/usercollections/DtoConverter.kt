package org.tsdes.usercollections

import org.tsdes.usercollections.db.CardCopy
import org.tsdes.usercollections.db.User
import org.tsdes.usercollections.dtos.CardCopyDto
import org.tsdes.usercollections.dtos.UserDto

object DtoConverter {

    fun transform(user : User) : UserDto {
        return UserDto().apply {
            userId = user.userId
            coins = user.coins
            cardPacks = user.cardPacks
            ownedCards = user.ownedCards.map {
                transform(it)
            }.toMutableList()

        }
    }

    fun transform(cardCopy : CardCopy) : CardCopyDto {
        return CardCopyDto().apply {
            cardId = cardCopy.cardId
            numberOfCopies = cardCopy.numberOfCopies
        }
    }
}
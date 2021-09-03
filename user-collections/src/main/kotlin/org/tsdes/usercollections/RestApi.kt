package org.tsdes.usercollections

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.tsdes.usercollections.db.UserService
import org.tsdes.usercollections.dtos.UserDto
import javax.websocket.server.PathParam


@Api("/api/user-collection", description = "Operations on card collections owned by users")
@RequestMapping(
    path = ["/api/user-collection"],
    produces = [(MediaType.APPLICATION_JSON_VALUE)]
)
@RestController
class RestApi (
    val userService: UserService
){

    @ApiOperation("retrieving a user with given id")
    @GetMapping(path = ["/{userId}"])
    fun getUserInfo(
        @PathVariable("userId") userId : String
    ) : ResponseEntity<UserDto>
    {
        val user = userService.findByIdEager(userId)

        if(user == null) {
            return ResponseEntity.status(404).build()
        }
        return ResponseEntity.status(200).body(DtoConverter.transform(user))
    }

    @ApiOperation("create/change user")
    @PutMapping(path = ["/{userId}"])
    fun putUserInfo(
        @PathVariable("userId") userId : String
    ) : ResponseEntity<String>
    {
        val result = userService.registerNewUser(userId)
        return if (result) {
            ResponseEntity.status(201).build()
        } else {
            ResponseEntity.status(400).build()
        }
    }
}
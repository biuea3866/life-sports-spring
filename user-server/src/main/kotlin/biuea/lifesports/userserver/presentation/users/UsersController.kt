package biuea.lifesports.userserver.presentation.users

import biuea.lifesports.userserver.application.users.UsersFacade
import biuea.lifesports.userserver.application.users.input.UsersFacadeInput
import biuea.lifesports.userserver.application.users.output.UsersFacadeOutput
import biuea.lifesports.userserver.common.response.CommonResponse
import biuea.lifesports.userserver.presentation.users.request.UsersControllerRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = ["/users"])
class UsersController(val usersFacade: UsersFacade) {
    @PostMapping(
        value = ["/v1.0/signup"],
        produces = ["application/json; charset=utf-8"]
    )
    @ResponseBody
    fun signup(@RequestBody body: UsersControllerRequest.SignupV1): ResponseEntity<CommonResponse<Long>> {
        val output = this.usersFacade.signup(input = body.of())

        return output.of()
    }

    @GetMapping(
        value = ["/v1.0/user-info"],
        produces = ["application/json; charset=utf-8"]
    )
    @ResponseBody
    fun getUser(@RequestHeader("X-User-Id") userId: Long): ResponseEntity<CommonResponse<UsersFacadeOutput.GetUserInfo>> {
        return this.usersFacade.getUserInfo(input = UsersFacadeInput.GetUserInfoV1(userId = userId)).of()
    }
//
//    @PatchMapping(
//        value = ["/v1.0/info"],
//        produces = ["application/json; charset=utf-8"]
//    )
//    @ResponseBody
//    fun changeUserInfo(
//        @RequestHeader("X-User-Id") userId: Int,
//        @RequestBody body: UsersControllerRequest.ChangeUserInfoV1
//    ): ResponseEntity<CommonResponse<>> {
//
//    }
}
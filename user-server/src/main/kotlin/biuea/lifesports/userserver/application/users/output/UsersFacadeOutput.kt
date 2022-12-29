package biuea.lifesports.userserver.application.users.output

import biuea.lifesports.userserver.common.response.CommonResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class UsersFacadeOutput {
    class Signup(
        val userId: Int,
        val message: String
    ) {
        fun of(): ResponseEntity<CommonResponse<Int>> {
            return CommonResponse.of(
                status = HttpStatus.CREATED,
                body = CommonResponse(
                    success = true,
                    data = userId,
                    message = message
                )
            )
        }
    }
}
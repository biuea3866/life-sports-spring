package biuea.lifesports.userserver.application.users.output

import biuea.lifesports.userserver.common.response.CommonResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class UsersFacadeOutput {
    class Signup(
        val userId: Long,
        val message: String
    ) {
        fun of(): ResponseEntity<CommonResponse<Long>> {
            return CommonResponse.of(
                status = HttpStatus.CREATED,
                body = CommonResponse(
                    success = true,
                    data = this.userId,
                    message = this.message
                )
            )
        }
    }
}
package biuea.lifesports.userserver.application.users.output

import biuea.lifesports.userserver.common.response.CommonResponse
import biuea.lifesports.userserver.domain.users.constants.UserGrade
import biuea.lifesports.userserver.domain.users.constants.UserStatus
import biuea.lifesports.userserver.domain.users.result.UsersServiceResult
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.time.ZonedDateTime

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

    class GetUserInfo(
        val id: Long,
        val email: String,
        val nickname: String,
        val name: String?,
        val phone: String?,
        val status: UserStatus,
        val grade: UserGrade,
        val createdDate: ZonedDateTime,
        val updatedDate: ZonedDateTime?,
        val lastLoginAt: ZonedDateTime?
    ) {
        fun of(): ResponseEntity<CommonResponse<GetUserInfo>> {
            return CommonResponse.of(
                status = HttpStatus.OK,
                body = CommonResponse(
                    success = true,
                    data = this,
                    message = null
                )
            )
        }
    }
}
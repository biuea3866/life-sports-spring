package biuea.lifesports.authzserver.service.errors

import biuea.lifesports.authzserver.common.exception.CommonError

enum class UserErrors(
    val code: String,
    val message: String
) {
    IS_EXIST_EMAIL(
        code = "USERS-000001",
        message = "이미 존재하는 이메일입니다."
    ),
    NOT_FOUND_USER(
        code = "USERS-000002",
        message = "존재하지 않는 유저입니다."
    ),
    IS_NOT_ACTIVE_USER(
        code = "USERS-000003",
        message = "휴면 회원입니다."
    )
    ;

    companion object {
        fun of(error: UserErrors): CommonError {
            return CommonError(
                code = error.code,
                message = error.message
            )
        }
    }
}
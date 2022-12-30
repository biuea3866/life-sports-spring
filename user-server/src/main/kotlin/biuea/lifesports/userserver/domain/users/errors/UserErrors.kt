package biuea.lifesports.userserver.domain.users.errors

import biuea.lifesports.userserver.common.exception.CommonError

enum class UserErrors(
    val code: String,
    val message: String
) {
    IS_EXIST_EMAIL(
        code = "USERS-000001",
        message = "이미 존재하는 이메일입니다."
    );

    companion object {
        fun of(error: UserErrors): CommonError {
            return CommonError(
                code = error.code,
                message = error.message
            )
        }
    }
}
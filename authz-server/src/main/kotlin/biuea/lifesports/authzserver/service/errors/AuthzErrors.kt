package biuea.lifesports.authzserver.service.errors

import biuea.lifesports.authzserver.common.exception.CommonError

enum class AuthzErrors(
    val code: String,
    val message: String
) {
    IS_NOT_EXIST_AUTHORITY(
        code = "AUTHZ-000001",
        message = "존재하지 않는 권한입니다."
    ),
    IS_NOT_EXIST_FUNCTION(
        code = "AUTHZ-000002",
        message = "존재하지 않는 기능입니다."
    ),
    NOT_AVAILABLE_FUNCTION(
        code = "AUTHZ-000003",
        message = "이용할 수 없는 등급입니다."
    )
    ;

    companion object {
        fun of(error: AuthzErrors): CommonError {
            return CommonError(
                code = error.code,
                message = error.message
            )
        }
    }
}
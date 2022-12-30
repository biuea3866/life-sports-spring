package biuea.lifesports.authzserver.service.errors

import biuea.lifesports.authzserver.common.exception.CommonError

enum class GradeAuthorityErrors(
    val code: String,
    val message: String
) {
    IS_NOT_EXIST_AUTHORITY(
        code = "GRADE_AUTHORITY-000001",
        message = "존재하지 않는 권한입니다."
    )
    ;

    companion object {
        fun of(error: GradeAuthorityErrors): CommonError {
            return CommonError(
                code = error.code,
                message = error.message
            )
        }
    }
}
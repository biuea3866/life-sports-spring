package biuea.lifesports.authnserver.common.exception

import biuea.lifesports.authzserver.common.exception.BaseException
import biuea.lifesports.authzserver.common.exception.CommonError
import org.springframework.http.HttpStatus

class UnauthorizedException: BaseException {
    constructor(message: String) : super(statusCode = HttpStatus.UNAUTHORIZED, message = message) {}
    constructor(error: CommonError) : super(
        statusCode = HttpStatus.UNAUTHORIZED,
        message = error.message,
        code = error.code
    )
}
package biuea.lifesports.userserver.common.exception

import biuea.lifesports.authnserver.common.exception.CommonError
import org.springframework.http.HttpStatus

class BadGatewayException : BaseException {
    constructor(message: String) : super(
        statusCode = HttpStatus.BAD_GATEWAY,
        message = message
    )
    constructor(error: CommonError) : super(
        statusCode = HttpStatus.BAD_GATEWAY,
        message = error.message,
        code = error.code
    )
}
package biuea.lifesports.authzserver.common.exception

import org.springframework.http.HttpStatus

class BadRequestException : BaseException {
    constructor(message: String) : super(
        statusCode = HttpStatus.BAD_REQUEST,
        message = message
    )
    constructor(error: CommonError) : super(
        statusCode = HttpStatus.BAD_REQUEST,
        message = error.message,
        code = error.code
    )
}
package biuea.lifesports.authnserver.common.exception

import biuea.lifesports.authzserver.common.exception.BaseException
import biuea.lifesports.authzserver.common.exception.CommonError
import org.springframework.http.HttpStatus

class NotFoundException : BaseException {
    constructor(message: String) : super(
        statusCode = HttpStatus.NOT_FOUND,
        message = message
    )
    constructor(error: CommonError) : super(
        statusCode = HttpStatus.NOT_FOUND,
        message = error.message,
        code = error.code
    )
}
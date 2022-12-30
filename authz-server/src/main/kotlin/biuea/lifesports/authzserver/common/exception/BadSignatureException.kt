package biuea.lifesports.authzserver.common.exception

import org.springframework.http.HttpStatus

class BadSignatureException(message: String?) : BaseException(HttpStatus.BAD_REQUEST, message)
package biuea.lifesports.authzserver.common.exception.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class CommonResponse<T>(
    success: Boolean,
    data: T?,
    message: String
) {
    companion object {
        fun<T> of(
            body: CommonResponse<T>,
            status: HttpStatus
        ): ResponseEntity<CommonResponse<T>> {
            return ResponseEntity(
                body,
                status
            )
        }
    }
}
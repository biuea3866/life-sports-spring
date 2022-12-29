package biuea.lifesports.userserver.common.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class CommonResponse<T>(
    data: T?,
    message: String
) {
    companion object {
        fun<T> of(
            body: CommonResponse<T>,
            status: HttpStatus
        ): ResponseEntity<CommonResponse<T>> {
            return ResponseEntity<CommonResponse<T>>(
                body,
                status
            )
        }
    }
}
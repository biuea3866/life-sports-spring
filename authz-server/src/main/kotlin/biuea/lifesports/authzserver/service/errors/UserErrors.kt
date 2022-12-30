package biuea.lifesports.authzserver.service.errors

enum class UserErrors(
    val code: String,
    val message: String
) {
    NOT_FOUND_USER
}
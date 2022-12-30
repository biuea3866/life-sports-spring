package biuea.lifesports.userserver.domain.users

interface UsersReader {
    fun isDuplicatedEmail(email: String)
}
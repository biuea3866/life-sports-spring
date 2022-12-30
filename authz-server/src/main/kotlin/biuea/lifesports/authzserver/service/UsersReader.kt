package biuea.lifesports.authzserver.service

interface UsersReader {
    fun isActiveUser(userId: Long)
}
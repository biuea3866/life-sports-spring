package biuea.lifesports.authzserver.service

import biuea.lifesports.authzserver.service.entity.User

interface UsersReader {
    fun isActiveUser(userId: Long): User
}
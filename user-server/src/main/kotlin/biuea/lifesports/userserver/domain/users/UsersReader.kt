package biuea.lifesports.userserver.domain.users

import biuea.lifesports.userserver.domain.users.entity.User

interface UsersReader {
    fun isDuplicatedEmail(email: String)
    fun getUserInfo(userId: Long): User
}
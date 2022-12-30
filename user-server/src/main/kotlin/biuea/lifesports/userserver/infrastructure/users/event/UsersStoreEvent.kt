package biuea.lifesports.userserver.infrastructure.users.event

import biuea.lifesports.userserver.domain.users.command.UsersCommandDomain

class UsersStoreEvent {
    class CreateUser(
        email: String,
        password: String,
        nickname: String,
        name: String?,
        phone: String?,
    ): UsersCommandDomain.UserDomain(
        email = email,
        password = password,
        nickname = nickname,
        name = name,
        phone = phone,
    )
}
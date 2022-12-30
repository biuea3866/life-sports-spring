package biuea.lifesports.userserver.domain.users.command

import biuea.lifesports.userserver.domain.users.entity.User
import biuea.lifesports.userserver.infrastructure.histories.event.HistoriesHandlerEvent
import biuea.lifesports.userserver.infrastructure.users.event.UsersStoreEvent

class UsersServiceCommand {
    class SignupV1(
        val email: String,
        val password: String,
        val nickname: String,
        val name: String?,
        val phone: String?,
    ) {
        fun toCreateUserEvent(): UsersStoreEvent.CreateUser {
            return UsersStoreEvent.CreateUser(
                email = this.email,
                password = this.password,
                nickname = this.nickname,
                name = this.name,
                phone = this.phone
            )
        }

        fun toCreateUserHistory(user: User): HistoriesHandlerEvent.CreateUserHistory {
            return HistoriesHandlerEvent.CreateUserHistory(
                name = this.name,
                nickname = this.nickname,
                user = user
            )
        }
    }

    class GetUserInfoV1()
}
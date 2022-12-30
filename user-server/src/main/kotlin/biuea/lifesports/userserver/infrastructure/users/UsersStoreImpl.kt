package biuea.lifesports.userserver.infrastructure.users

import biuea.lifesports.userserver.domain.users.UsersStore
import biuea.lifesports.userserver.domain.users.entity.User
import biuea.lifesports.userserver.infrastructure.users.event.UsersStoreEvent
import org.springframework.stereotype.Component

@Component
class UsersStoreImpl(val usersRepository: UsersRepository): UsersStore {
    override fun createUser(event: UsersStoreEvent.CreateUser): User {
        val user = event.toEntity()

        user.makeEncryptPassword()

        return this.usersRepository.save(user)
    }
}
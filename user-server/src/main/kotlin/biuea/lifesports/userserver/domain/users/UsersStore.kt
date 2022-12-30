package biuea.lifesports.userserver.domain.users

import biuea.lifesports.userserver.domain.users.entity.User
import biuea.lifesports.userserver.infrastructure.users.event.UsersStoreEvent

interface UsersStore {
    fun createUser(event: UsersStoreEvent.CreateUser): User
}
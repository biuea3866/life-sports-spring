package biuea.lifesports.userserver.infrastructure.users

import biuea.lifesports.userserver.domain.users.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<User, Long> {
    fun existsByEmail(email: String): Boolean
}
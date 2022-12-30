package biuea.lifesports.authzserver.infrastructure

import biuea.lifesports.authzserver.service.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<User, Long> {
}
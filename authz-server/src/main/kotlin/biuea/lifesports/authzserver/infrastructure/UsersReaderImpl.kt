package biuea.lifesports.authzserver.infrastructure

import biuea.lifesports.authzserver.service.UsersReader
import org.springframework.stereotype.Component

@Component
class UsersReaderImpl(val usersRepository: UsersRepository): UsersReader {
    override fun isActiveUser(userId: Long) {
        val user = this.usersRepository.findById(userId)
            .orElseThrow { throw  }
        if (user.)
    }
}
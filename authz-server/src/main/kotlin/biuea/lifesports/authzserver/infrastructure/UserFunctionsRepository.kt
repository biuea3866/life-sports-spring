package biuea.lifesports.authzserver.infrastructure

import biuea.lifesports.authzserver.service.entity.UserFunction
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserFunctionsRepository: JpaRepository<UserFunction, Long> {
    fun findByFunctionName(functionName: String): Optional<UserFunction>
}
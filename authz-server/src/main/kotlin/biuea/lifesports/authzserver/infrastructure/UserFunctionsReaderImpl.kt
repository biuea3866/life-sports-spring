package biuea.lifesports.authzserver.infrastructure

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.authzserver.service.UserFunctionsReader
import biuea.lifesports.authzserver.service.constants.UserGrade
import biuea.lifesports.authzserver.service.entity.UserFunctionGrades
import biuea.lifesports.authzserver.service.errors.AuthzErrors
import org.springframework.stereotype.Component

@Component
class UserFunctionsReaderImpl(val userFunctionsRepository: UserFunctionsRepository): UserFunctionsReader {
    override fun isValidFunction(grade: UserGrade, functionName: String) {
        val function = this.userFunctionsRepository.findByFunctionName(functionName = functionName)
            .orElseThrow { ForbiddenException(AuthzErrors.of(error = AuthzErrors.IS_NOT_EXIST_FUNCTION)) }
        val userFunctionGrades = UserFunctionGrades(userFunctionGrades = function.userFunctionGrades)

        userFunctionGrades.isAvailableGrade(userGrade = grade)
    }
}
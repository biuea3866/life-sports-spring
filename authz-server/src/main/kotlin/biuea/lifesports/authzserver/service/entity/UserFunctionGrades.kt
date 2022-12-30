package biuea.lifesports.authzserver.service.entity

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.authzserver.service.constants.UserGrade
import biuea.lifesports.authzserver.service.errors.AuthzErrors

class UserFunctionGrades(val userFunctionGrades: List<UserFunctionGrade>) {
    fun isAvailableGrade(userGrade: UserGrade) {
        val grade = this.userFunctionGrades.filter { it.grade == userGrade }

        if (grade.isEmpty()) throw ForbiddenException(AuthzErrors.of(error = AuthzErrors.NOT_AVAILABLE_FUNCTION))
    }
}
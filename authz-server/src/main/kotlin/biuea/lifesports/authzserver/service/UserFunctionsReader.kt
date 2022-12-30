package biuea.lifesports.authzserver.service

import biuea.lifesports.authzserver.service.constants.UserGrade

interface UserFunctionsReader {
    fun isValidFunction(
        grade: UserGrade,
        functionName: String
    )
}
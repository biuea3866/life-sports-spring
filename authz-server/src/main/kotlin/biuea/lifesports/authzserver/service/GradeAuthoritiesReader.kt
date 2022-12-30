package biuea.lifesports.authzserver.service

import biuea.lifesports.authzserver.service.constants.UserGrade

interface GradeAuthoritiesReader {
    fun isValidGrade(
        grade: UserGrade,
        functionName: String
    )
}
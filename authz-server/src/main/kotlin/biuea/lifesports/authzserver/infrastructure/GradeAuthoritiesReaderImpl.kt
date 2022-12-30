package biuea.lifesports.authzserver.infrastructure

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.authzserver.service.GradeAuthoritiesReader
import biuea.lifesports.authzserver.service.constants.UserGrade
import biuea.lifesports.authzserver.service.errors.GradeAuthorityErrors
import org.springframework.stereotype.Component

@Component
class GradeAuthoritiesReaderImpl(val gradeAuthoritiesRepository: GradeAuthoritiesRepository): GradeAuthoritiesReader {
    override fun isValidGrade(grade: UserGrade, functionName: String) {
        val isExist = this.gradeAuthoritiesRepository.existsByUserGradeAndFunctionName(
            userGrade = grade,
            functionName = functionName
        )

        if (!isExist) throw ForbiddenException(GradeAuthorityErrors.of(error = GradeAuthorityErrors.IS_NOT_EXIST_AUTHORITY))
    }
}
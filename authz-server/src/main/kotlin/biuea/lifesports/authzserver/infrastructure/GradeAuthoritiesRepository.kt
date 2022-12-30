package biuea.lifesports.authzserver.infrastructure

import biuea.lifesports.authzserver.service.constants.UserGrade
import biuea.lifesports.authzserver.service.entity.GradeAuthority
import org.springframework.data.jpa.repository.JpaRepository

interface GradeAuthoritiesRepository: JpaRepository<GradeAuthority, Long> {
    fun existsByUserGradeAndFunctionName(
        userGrade: UserGrade,
        functionName: String
    ): Boolean
}
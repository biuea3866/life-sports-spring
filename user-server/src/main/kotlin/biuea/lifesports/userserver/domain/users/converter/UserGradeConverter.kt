package biuea.lifesports.userserver.domain.users.converter

import biuea.lifesports.grpc.authz.UserGrade

class UserGradeConverter {
    fun toKotlinUserGradeConvert(grade: UserGrade): biuea.lifesports.userserver.domain.users.constants.UserGrade {
        return biuea.lifesports.userserver.domain.users.constants.UserGrade.values().find { it.name == grade.name }
            ?: throw NoSuchElementException("존재하지 않는 상태값입니다.")
    }
}
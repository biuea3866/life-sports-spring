package biuea.lifesports.authzserver.service.converter

import biuea.lifesports.authzserver.service.constants.UserGrade

class UserGradeConverter {
    fun convert(userGrade: doodlin.greeting.grpc.proto.user.UserGrade): UserGrade {
        return UserGrade.values().find { it.name == userGrade.name }?: throw NoSuchElementException("존재하지 않는 등급입니다.")
    }
}
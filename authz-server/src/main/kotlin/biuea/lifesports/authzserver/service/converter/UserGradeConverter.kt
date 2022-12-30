package biuea.lifesports.authzserver.service.converter

import biuea.lifesports.authzserver.service.constants.UserGrade

class UserGradeConverter {
    fun convertToKotlinGrade(userGrade: biuea.lifesports.grpc.authz.UserGrade): UserGrade {
        return UserGrade.values().find { it.name == userGrade.name }?: throw NoSuchElementException("존재하지 않는 등급입니다.")
    }

    fun convertToGrpcGrade(userGrade: UserGrade): biuea.lifesports.grpc.authz.UserGrade {
        return biuea.lifesports.grpc.authz.UserGrade.values().find { it.name == userGrade.name }?: throw NoSuchElementException("존재하지 않는 등급입니다.")
    }
}
package biuea.lifesports.userserver.common.authorization.annotation

import biuea.lifesports.userserver.domain.users.constants.UserGrade

annotation class AuthorizeUser(val grade: Array<UserGrade> = [])

package biuea.lifesports.userserver.common.authorization.annotation

import biuea.lifesports.userserver.common.authorization.constants.FunctionName

annotation class AuthorizeUser(val functionName: Array<FunctionName> = [])

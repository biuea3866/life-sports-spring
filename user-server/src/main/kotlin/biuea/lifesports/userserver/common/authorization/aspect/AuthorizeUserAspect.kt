package biuea.lifesports.userserver.common.authorization.aspect

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.userserver.common.authorization.annotation.AuthorizeUser
import biuea.lifesports.userserver.common.authorization.constants.FunctionName
import biuea.lifesports.userserver.common.authorization.input.AuthorizeInput
import biuea.lifesports.userserver.domain.auth.AuthzService
import biuea.lifesports.userserver.domain.auth.command.AuthzServiceCommand
import biuea.lifesports.userserver.domain.auth.result.AuthzServiceResult
import biuea.lifesports.userserver.domain.users.constants.UserGrade
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import java.lang.reflect.Method

class AuthorizeUserAspect(val authzService: AuthzService) {
    @Pointcut("@annotation(biuea.lifesports.userserver.common.authorization.annotation.AuthorizeUser)")
    fun cut() {
    }

    @Around(value = "cut()")
    fun checkFunction(joinPoint: ProceedingJoinPoint): Any {
        val annotation = this.getAnnotation(joinPoint)
        val input = joinPoint.args.firstOrNull { it::class.java == AuthorizeInput::class.java } as AuthorizeInput?

        this.checkAuthorizationInput(input = input)

        val functionName = annotation.functionName.first()
        val authResult = this.getUserAuthorizations(
            functionName = functionName,
            userId = input!!.userId
        )
        val index = joinPoint.args.indexOfFirst { it is AuthzServiceResult.GetAuthorizationUser }

        if (index != -1) joinPoint.args[index] = authResult

        return joinPoint.proceed(joinPoint.args)
    }

    private fun checkAuthorizationInput(input: AuthorizeInput?) {
        if (input !is AuthorizeInput || input.userId == 0L) {
            throw IllegalArgumentException("Input must be AuthorizationInput")
        }
    }

    private fun getUserAuthorizations(
        functionName: FunctionName,
        userId: Long
    ): AuthzServiceResult.GetAuthorizationUser {
        return this.authzService.getAuthorizationUser(
            AuthzServiceCommand.GetAuthorizationUser(
                userId = userId,
                functionName = functionName.name
            )
        )
    }

    private fun getAnnotation(joinPoint: ProceedingJoinPoint): AuthorizeUser {
        val signature: MethodSignature = joinPoint.signature as MethodSignature
        val method: Method = signature.method

        return method.getAnnotation(AuthorizeUser::class.java)
    }
}
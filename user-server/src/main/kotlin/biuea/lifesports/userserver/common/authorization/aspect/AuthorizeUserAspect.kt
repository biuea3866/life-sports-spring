package biuea.lifesports.userserver.common.authorization.aspect

import biuea.lifesports.authnserver.common.exception.ForbiddenException
import biuea.lifesports.userserver.common.authorization.input.AuthorizeInput
import biuea.lifesports.userserver.domain.users.constants.UserGrade
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import java.lang.reflect.Method

class AuthorizeUserAspect {
    @Pointcut("@annotation(biuea.lifesports.userserver.common.authorization.annotation.AuthorizeUser)")
    fun cut() {
    }

    @Around(value = "cut()")
    fun checkFunction(joinPoint: ProceedingJoinPoint): Any {
        val annotation = this.getAnnotation(joinPoint)
        val input = joinPoint.args.firstOrNull { it::class.java == AuthorizeInput::class.java } as AuthorizeInput?

        this.checkAuthorizationInput(input = input)

        val grades = annotation.grades
        val authResult = this.getWorkspaceFunctionAuthorizations(
            functions = functions,
            userId = authorizationInput.userId,
            workspaceId = authorizationInput.workspaceId
        )

        authResult.workspaceFunctionAuthorizations
            .filter { it.isEssential }
            .forEach { if (!it.isAuthorized) throw ForbiddenException("Not authorized - ${it.functionName}") }

        if (joinPoint.args[joinPoint.args.size - 1]::class.java == AuthServiceResult.WorkspaceFunctionAuthorizations::class.java) {
            joinPoint.args[joinPoint.args.size - 1] = authResult
        }

        return joinPoint.proceed(joinPoint.args)
    }

    private fun checkAuthorizationInput(input: AuthorizeInput?) {
        if (input !is AuthorizeInput || input.userId == 0) {
            throw IllegalArgumentException("Input must be AuthorizationInput")
        }
    }

    private fun getUserAuthorizations(
        grades: Array<UserGrade>,
        userId: Int,
        workspaceId: Int
    ): AuthServiceResult.WorkspaceFunctionAuthorizations {
        return this.authzService.getWorkspaceFunctionAuthorizations(
            AuthServiceCommand.GetWorkspaceFunctionAuthorizationsByUserId(
                userId = userId,
                workspaceId = workspaceId,
                functions = functions
            )
        )
    }

    private fun getAnnotation(joinPoint: ProceedingJoinPoint): AuthorizeWorkspaceFunction {
        val signature: MethodSignature = joinPoint.signature as MethodSignature
        val method: Method = signature.method

        return method.getAnnotation(AuthorizeWorkspaceFunction::class.java)
    }
}
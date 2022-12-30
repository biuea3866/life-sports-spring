package biuea.lifesports.userserver.domain.users.constants

enum class UsersMessage(val message: String) {
    CREATE_USER("%s 유저님 가입을 진심으로 축하합니다!")
    ;

    fun options(vararg options: Any = arrayOf(0)): String {
        return this.message.format(*options)
    }
}
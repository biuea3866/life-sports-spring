package biuea.lifesports.userserver.infrastructure.histories.event

import biuea.lifesports.userserver.domain.histories.command.HistoryCommandDomain
import biuea.lifesports.userserver.domain.histories.constants.HistoryDescription
import biuea.lifesports.userserver.domain.histories.constants.HistoryType
import biuea.lifesports.userserver.domain.users.entity.User

class HistoriesHandlerEvent {
    class CreateUserHistory(
        val name: String?,
        val nickname: String,
        user: User,
        historyType: HistoryType = HistoryType.USER,
        description: String = HistoryDescription.CREATE_USER.options(name?: nickname)
    ): HistoryCommandDomain.HistoryDomain(
        user = user,
        historyType = historyType,
        description = description
    )
}
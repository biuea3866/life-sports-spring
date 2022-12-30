package biuea.lifesports.userserver.domain.histories.command

import biuea.lifesports.userserver.domain.histories.constants.HistoryDescription
import biuea.lifesports.userserver.domain.histories.constants.HistoryType
import biuea.lifesports.userserver.domain.histories.entity.History
import biuea.lifesports.userserver.domain.users.entity.User

class HistoryCommandDomain {
    open class HistoryDomain(
        val historyType: HistoryType,
        val description: String,
        val user: User
    ) {
        fun toEntity(): History {
            return History(
                historyType = this.historyType,
                description = this.description,
                user = this.user
            )
        }
    }
}
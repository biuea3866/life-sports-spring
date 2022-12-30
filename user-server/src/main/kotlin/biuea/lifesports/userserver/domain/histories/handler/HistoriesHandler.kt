package biuea.lifesports.userserver.domain.histories.handler

import biuea.lifesports.userserver.infrastructure.histories.event.HistoriesHandlerEvent

interface HistoriesHandler {
    fun createUserHistory(event: HistoriesHandlerEvent.CreateUserHistory)
}
package biuea.lifesports.userserver.infrastructure.histories.handler

import biuea.lifesports.userserver.domain.histories.command.HistoryCommandDomain
import biuea.lifesports.userserver.domain.histories.handler.HistoriesHandler
import biuea.lifesports.userserver.infrastructure.histories.event.HistoriesHandlerEvent
import biuea.lifesports.userserver.infrastructure.histories.repository.HistoriesRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener
import javax.transaction.Transactional

@Component
class HistoriesHandlerImpl(val historiesRepository: HistoriesRepository): HistoriesHandler {
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    @Transactional
    override fun createUserHistory(event: HistoriesHandlerEvent.CreateUserHistory) {
        this.historiesRepository.save(event.toEntity())
    }
}
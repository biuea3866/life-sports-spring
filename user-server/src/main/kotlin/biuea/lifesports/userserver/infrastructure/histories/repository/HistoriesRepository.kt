package biuea.lifesports.userserver.infrastructure.histories.repository

import biuea.lifesports.userserver.domain.histories.entity.History
import org.springframework.data.jpa.repository.JpaRepository

interface HistoriesRepository: JpaRepository<History, Long> {
}
package biuea.lifesports.authzserver.service.entity

import javax.persistence.*

@Entity
@Table(name = "GradeFunctions")
class GradeFunction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @Column(name = "function_name")
    var functionName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
) {
}
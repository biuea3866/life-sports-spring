package biuea.lifesports.userserver.domain.reviews.entity

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import javax.persistence.Entity
import javax.persistence.Id

@Document(collection = "ReviewImages")
class ReviewImage(
    @Id
    var id: ObjectId = ObjectId(),

    @Field(name = "file_name")
    var fileName: String,

    @Field(name = "file_type")
    var fileType: String,

    @Field(name = "file_size")
    var fileSize: Int,

    var bucket: String,

    var key: String
) {
}
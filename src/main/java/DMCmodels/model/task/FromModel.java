package DMCmodels.model.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "froms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FromModel {
    @Id
    private ObjectId id;
}

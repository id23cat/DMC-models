package DMCmodels.model.task;

import DMCmodels.dto.ArgumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collation = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {

    @Id
    private ObjectId id;
    @Indexed
    private String name;
    private ArgumentType type;
    private Object defaultType;
    private List<BlockModel> blockModels;

    public TaskModel(String name, ArgumentType type, Object defaultType, List<BlockModel> blockModels) {
        this.name = name;
        this.type = type;
        this.defaultType = defaultType;
        this.blockModels = blockModels;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(String id) {
        this.id = new ObjectId(id);
    }
}

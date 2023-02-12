package patika.dev.definex.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class BaseModel {
    public long id;
    public String insertTime;
}

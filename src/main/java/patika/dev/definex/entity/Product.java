package patika.dev.definex.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Product extends BaseModel {
    private long itemSKU;
    private long size;
    private String name;
    private String group;
    private String brand;
    private String description;
}

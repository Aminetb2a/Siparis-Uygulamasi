package patika.dev.definex.entity;

import lombok.Data;

@Data
public class Product {
    private long id;
    private long itemSKU;
    private long size;
    private String name;
    private String group;
    private String brand;
    private String description;
}

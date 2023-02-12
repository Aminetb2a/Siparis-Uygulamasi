package patika.dev.definex.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
public class Order extends BaseModel {
    private double qty;
    private long itemId;
    private long orderNo;
    private double value;
    private String status;
    private long customerId;
    private String description;
    private double totalAmount;
    private LocalDate orderDate;
    private String trackingNumber;

}

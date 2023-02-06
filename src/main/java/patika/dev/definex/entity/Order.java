package patika.dev.definex.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Order {
    private long id;
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

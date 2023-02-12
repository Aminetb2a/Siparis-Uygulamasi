package patika.dev.definex.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Invoice extends BaseModel {
    private double qty;
    private double tax;
    private long itemId;
    private String sector;
    private long invoiceNo;
    private boolean isPaid;
    private String payType;
    private long customerId;
    private String customerName;
    private long orderId;
    private String description;
    private double totalAmount;
    private String transDate;
}

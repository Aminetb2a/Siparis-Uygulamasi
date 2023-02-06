package patika.dev.definex.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Invoice {
    private long id;
    private double qty;
    private double tax;
    private long itemId;
    private String sector;
    private long invoiceNo;
    private boolean isPaid;
    private String payType;
    private long currencyId;
    private long customerId;
    private String customerName;
    private List<Long> orderId;
    private String description;
    private double totalAmount;
    private String currencyCode;
    private LocalDate transDate;
}

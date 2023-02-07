package patika.dev.definex.entity;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Customer {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String surname;
    private long customerNo;
    private String postalCode;
    private String insDate;
    private String shipAddress;
    private String billAddress;

}

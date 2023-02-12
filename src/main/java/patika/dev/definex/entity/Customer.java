package patika.dev.definex.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class Customer extends BaseModel {
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

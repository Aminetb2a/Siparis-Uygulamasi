package patika.dev.definex.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String surname;
    private long customerNo;
    private String postalCode;
    private LocalDate insDate;
    private String shipAddress;
    private String billAddress;

}

package patika.dev.definex;

import com.github.lalyos.jfiglet.FigletFont;
import patika.dev.definex.entity.Customer;
import patika.dev.definex.service.CommonService;
import patika.dev.definex.service.CustomerService;
import patika.dev.definex.service.InvoiceService;

import java.io.IOException;
import java.time.LocalDate;

public class SiparisUygulamasiApplication {

    private final static String leftAlignFormat = "%n%n\t************************* %s *************************%n%n";

    public static void main(String[] args) throws IOException {

        System.out.println(FigletFont.convertOneLine("Sipariş Uygulaması"));

        InvoiceService invoiceService = new InvoiceService();
        CustomerService customerService = new CustomerService();
        CommonService commonService = new CommonService(invoiceService, customerService);


        //Tüm müşterileri listeleyin
        System.out.format(leftAlignFormat, "Tüm müşterileri listesı");
        customerService.getAllCustomer().stream().forEach(System.out::println);


        //Yeni Müşteri oluşturabilen
        Customer customer = Customer.builder()
                .id(42857)
                .name("Tandy")
                .customerNo(436)
                .surname("Niessen")
                .postalCode("5504")
                .phone("+7 871 482 3332")
                .email("tandy4@paypal.com")
                .billAddress("461 Melrose Terrace")
                .shipAddress("474 Cordelia Terrace")
                .insDate(LocalDate.now().toString())
                .build();
        customerService.addCustomer(customer);


        //İçerisinde ‘C’ harfi olan müşterileri listeleyin
        System.out.format(leftAlignFormat, "İçerisinde ‘C’ harfi olan müşterileri listesı");
        customerService.getCustomerByName("c").stream().forEach(System.out::println);


        //Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleyin
        System.out.format(leftAlignFormat, "Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listesı");
        System.out.println((commonService.getTotalAmountOfAllCustomersByInsertionMonth(6)));


        //Sistemdeki tüm faturaları listeleyin
        System.out.format(leftAlignFormat, "Sistemdeki tüm faturaları listesı");
        invoiceService.getAllInvoices().stream().forEach(System.out::println);


        //Sistemdeki 1500TL üstündeki faturaları listeleyin
        System.out.format(leftAlignFormat, "Sistemdeki 1500TL üstündeki faturaları listesı");
        invoiceService.getInvoicesTotalGreaterThan(1500).stream().forEach(System.out::println);


        //Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplayın
        System.out.format(leftAlignFormat, "Sistemdeki 1500TL üstündeki faturaları ortalaması");
        System.out.println((invoiceService.getAverageOfInvoicesTotalAmountGreaterThan(1500)));


        //Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin
        System.out.format(leftAlignFormat, "Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listesı");
        invoiceService.getCustomerNamesWithTotalInvoicesSmallerThan(500).stream().forEach(System.out::println);


        //Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kodu yazın.
        System.out.format(leftAlignFormat, "Haziran ayını faturalarını ortalaması 750 altı olan firmalarının sektör listesı");
        invoiceService.getTotalAmountAverageInvoicesByMonth(6, 750).stream().forEach(System.out::println);

    }
}

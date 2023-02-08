package patika.dev.definex;

import patika.dev.definex.entity.Customer;
import patika.dev.definex.service.CommonService;
import patika.dev.definex.service.CustomerService;
import patika.dev.definex.service.InvoiceService;

import java.io.IOException;

public class SiparisUygulamasiApplication {

    public static void main(String[] args) throws IOException {

        InvoiceService invoiceService = new InvoiceService();
        CustomerService customerService = new CustomerService();
        CommonService commonService = new CommonService(invoiceService, customerService);


        //Tüm müşterileri listeleyin
        System.out.println("\n\n*************************Tüm müşterileri listeleyin*************************\n");
        customerService.getAllCustomer().stream().forEach(System.out::println);


        //        Yeni Müşteri oluşturabilen
        Customer customer = Customer.builder()
                .customerNo(999)
                .id(42857)
                .name("Tandy")
                .phone("+7 871 482 3332")
                .insDate("01/09/2022")
                .surname("Niessen")
                .customerNo(43)
                .postalCode("5504")
                .shipAddress("474 Cordelia Terrace")
                .billAddress("461 Melrose Terrace")
                .build();
        customerService.addCustomer(customer);


        //        İçerisinde ‘C’ harfi olan müşterileri listeleyin
        System.out.println("\n\n*************************İçerisinde ‘C’ harfi olan müşterileri listeleyin*************************\n");
        System.out.println((customerService.getCustomerByName("c")));


        //        Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleyin
        System.out.println("\n\n*************************Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleyin*************************\n");
        System.out.println((commonService.getTotalAmountOfAllCustomersByInsertionMonth(06)));


        //        Sistemdeki tüm faturaları listeleyin
        System.out.println("\n\n*************************Sistemdeki tüm faturaları listeleyin*************************\n");
        invoiceService.getAllInvoices().stream().forEach(System.out::println);


        //        Sistemdeki 1500TL üstündeki faturaları listeleyin
        System.out.println("\n\n*************************Sistemdeki 1500TL üstündeki faturaları listeleyin*************************\n");
        invoiceService.getInvoicesTotalGreaterThan(1500).stream().forEach(System.out::println);


        //        Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplayın
        System.out.println("\n\n*************************Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplayın*************************\n");
        System.out.println((invoiceService.getAverageOfInvoicesTotalAmountGreaterThan(1500)));


        //        Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin
        System.out.println("\n\n*************************Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin*************************\n");
        invoiceService.getCustomerNamesWithTotalInvoicesSmallerThan(500).stream().forEach(System.out::println);


        //        Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kodu yazın.
        System.out.println("\n\n*************************Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kodu yazın.*************************\n");
        invoiceService.getTotalAmountAverageInvoicesByMonth(06, 750).stream().forEach(System.out::println);
    }
}

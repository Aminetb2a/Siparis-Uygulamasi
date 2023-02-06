package patika.dev.definex.service;

import patika.dev.definex.entity.Customer;
import patika.dev.definex.entity.Invoice;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CommonService {

    private InvoiceService invoiceService;
    private CustomerService customerService;

    public CommonService(InvoiceService invoiceService, CustomerService customerService) {
        this.invoiceService = invoiceService;
        this.customerService = customerService;
    }

    public double getTotalAmountOfAllCustomersByInsertionMonth(int month) throws IOException {
        List<Long> customers = customerService.getCustomerByInsertionMonth(month)
                .parallelStream()
                .map(Customer::getId)
                .collect(Collectors.toList());

        return invoiceService.getAllInvoices()
                .parallelStream()
                .filter(invoice -> customers.contains(invoice.getCustomerId()))
                .mapToDouble(Invoice::getTotalAmount)
                .sum();
    }
}

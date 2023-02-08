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

    /**
     * This function gets all invoices for all customers that were inserted in a given month, and sum their total
     * amounts.
     * 
     * The first thing we do is get all customers that were inserted in the given month. We then get
     * all invoices for those customers, and sum their total amounts
     * 
     * @param month The month of the year (1-12)
     * @return The total amount of all invoices for all customers that were inserted in the database in
     * a specific month.
     */
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

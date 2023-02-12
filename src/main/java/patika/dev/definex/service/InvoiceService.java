package patika.dev.definex.service;

import patika.dev.definex.entity.Invoice;
import patika.dev.definex.mockData.MockData;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class InvoiceService {

    private static List<Invoice> invoiceList = null;

    {
        try {
            invoiceList = MockData.getInvoices();
        } catch (Exception aE) {
            aE.printStackTrace();
        }
    }

    /**
     * This function returns a list of invoices.
     *
     * @return A list of Invoice objects.
     */
    public List<Invoice> getAllInvoices() {
        return invoiceList;
    }

    /**
     * This function gets the average total amount of invoices per sector for a given month, and return the sectors
     * that have an average total amount less than the given average
     *
     * @param month   The month to filter by.
     * @param average The maximum average total amount constraint.
     * @return A list of sectors that have an average invoice total less than the average invoice total
     * for the month.
     */
    public List<String> getTotalAmountAverageInvoicesByMonth(int month, double average) {
        return invoiceList
                .parallelStream()
                .collect(filtering(invoice -> LocalDate.parse(invoice.getTransDate()).getMonthValue() == month,
                        groupingBy(Invoice::getSector,
                                averagingDouble(Invoice::getTotalAmount))))
                .entrySet()
                .parallelStream()
                .filter(sector -> sector.getValue() < average)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    /**
     * This function gets all invoices where the total amount is greater than the given total.
     *
     * @param total the minimum total amount of the invoices
     * @return A list of invoices with a total amount greater than the total parameter.
     */
    public List<Invoice> getInvoicesTotalGreaterThan(double total) {
        return invoiceList
                .parallelStream()
                .filter(invoice -> invoice.getTotalAmount() > total)
                .collect(Collectors.toList());
    }

    /**
     * This function gets a list of customer names whose total invoices are less than the given total
     *
     * @param total The maximum total amount of invoices that a customer has.
     * @return A list of customer names with total invoices smaller than the total amount.
     */
    public List<String> getCustomerNamesWithTotalInvoicesSmallerThan(double total) {
        return invoiceList
                .parallelStream()
                .collect(groupingBy(Invoice::getCustomerName,
                        summingDouble(Invoice::getTotalAmount)))
                .entrySet()
                .parallelStream()
                .filter(map -> map.getValue() < total)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * This function gets the average of the total amount of invoices that have a total amount greater than the
     * given total
     *
     * @param total The minimum total amount of the invoice
     * @return The average of the total amount of all invoices that have a total amount greater than
     * the parameter total.
     */
    public double getAverageOfInvoicesTotalAmountGreaterThan(double total) {
        return invoiceList
                .parallelStream()
                .filter(invoice -> invoice.getTotalAmount() > total)
                .mapToDouble(Invoice::getTotalAmount)
                .average()
                .getAsDouble();
    }

}

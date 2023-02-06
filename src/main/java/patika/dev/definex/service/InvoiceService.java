package patika.dev.definex.service;

import patika.dev.definex.entity.Invoice;
import patika.dev.definex.mockData.MockData;

import java.util.List;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class InvoiceService {

    public List<Invoice> getAllInvoices() throws IOException {
        return MockData.getInvoices();
    }

    public List<Invoice> getTotalInvoicesByMonth(int month) throws IOException {
        return MockData.getInvoices()
                .parallelStream()
                .filter(invoice -> invoice.getTransDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }

    public List<String> getTotalInvoicesByMonth(int month, double average) throws IOException {
        Map<String, Double> averageGroupBySector = MockData.getInvoices()
                .parallelStream()
                .collect(groupingBy(Invoice::getSector,
                        filtering(invoice -> invoice.getTransDate().getMonthValue() == month,
                                averagingDouble(Invoice::getTotalAmount))));

        return averageGroupBySector.entrySet()
                .parallelStream()
                .filter(sector -> sector.getValue() < average )
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Invoice> getInvoicesTotalGreaterThan(double total) throws IOException {
        return MockData.getInvoices()
                .parallelStream()
                .filter(invoice -> invoice.getTotalAmount() > total)
                .collect(Collectors.toList());
    }

    public List<String> getInvoicesTotalSmallerThanCustomerName(double total) throws IOException {
        return MockData.getInvoices()
                .parallelStream()
                .filter(invoice -> invoice.getTotalAmount() < total)
                .map(Invoice::getCustomerName)
                .collect(Collectors.toList());
    }

    public double getInvoicesAverageOfTotalAmountGreaterThan(double total) throws IOException {
        return MockData.getInvoices()
                .parallelStream()
                .filter(invoice -> invoice.getTotalAmount() > total)
                .mapToDouble(Invoice::getTotalAmount)
                .average()
                .getAsDouble();
    }

}

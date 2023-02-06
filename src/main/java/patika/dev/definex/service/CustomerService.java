package patika.dev.definex.service;

import patika.dev.definex.entity.Customer;
import patika.dev.definex.mockData.MockData;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    public List<Customer> getCustomerList() throws IOException {
        return MockData.getCustomers();
    }

    public void addCustomer(Customer customer) throws IOException {
        MockData.getCustomers().add(customer);
    }

    public List<Customer> filterCustomerByName(String subName) throws IOException {
        return MockData.getCustomers()
                .parallelStream()
                .filter(customer -> customer.getName().contains(subName))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomerByInsertionMonth(int month) throws IOException {
        return MockData.getCustomers()
                .parallelStream()
                .filter(customer -> customer.getInsDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }

}

package patika.dev.definex.service;

import patika.dev.definex.entity.Customer;
import patika.dev.definex.mockData.MockData;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    /**
     * This function returns a list of customers.
     * 
     * @return A list of customers
     */
    public List<Customer> getAllCustomer() throws IOException {
        return MockData.getCustomers();
    }

    /**
     * This function adds a customer to the list of customers.
     * 
     * @param customer The customer object that is being added to the list.
     */
    public void addCustomer(Customer customer) throws IOException {
        MockData.getCustomers().add(customer);
    }

    /**
     * This function returns a list of customers whose name contains the given substring
     * 
     * @param subName The substring to search for in the customer name.
     * @return A list of customers whose name contains the substring subName.
     */
    public List<Customer> getCustomerByName(String subName) throws IOException {
        return MockData.getCustomers()
                .parallelStream()
                .filter(customer -> customer.getName().toLowerCase().contains(subName))
                .collect(Collectors.toList());
    }

    /**
     * This function returns all customers whose insertion date is in the given month.
     * 
     * @param month The month of the year (1-12)
     * @return A list of customers that were inserted in the month of the parameter.
     */
    public List<Customer> getCustomerByInsertionMonth(int month) throws IOException {
        return MockData.getCustomers()
                .parallelStream()
                .filter(customer -> LocalDate.parse(customer.getInsDate()).getMonthValue() == month)
                .collect(Collectors.toList());
    }

}

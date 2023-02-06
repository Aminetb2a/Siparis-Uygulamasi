package patika.dev.definex.mockData;

import com.google.common.reflect.TypeToken;
import patika.dev.definex.entity.Customer;
import patika.dev.definex.entity.Invoice;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.common.io.Resources;
import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;

public class MockData {

    public static List<Invoice> getInvoices() throws IOException {
        InputStream inputStream = Resources.getResource("invoice.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Invoice>>() {}.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Customer> getCustomers() throws IOException {
        InputStream inputStream = Resources.getResource("customer.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Customer>>() {}.getType();
        return new Gson().fromJson(json, listType);
    }
}

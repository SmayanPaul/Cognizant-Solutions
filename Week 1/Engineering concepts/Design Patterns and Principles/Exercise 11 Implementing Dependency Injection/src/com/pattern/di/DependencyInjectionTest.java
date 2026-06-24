package com.pattern.di;

interface CustomerRepository {
    String findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        if ("101".equals(id)) {
            return "John Doe (Enterprise Client)";
        } else if ("102".equals(id)) {
            return "Jane Smith (Premium Member)";
        }
        return null;
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerName(String id) {
        String name = customerRepository.findCustomerById(id);
        if (name == null) {
            return "Customer with ID " + id + " not found.";
        }
        return name;
    }
}

public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        System.out.println("--- Querying Customer 101 ---");
        String customer1 = service.getCustomerName("101");
        System.out.println("Result: " + customer1);

        System.out.println("\n--- Querying Customer 102 ---");
        String customer2 = service.getCustomerName("102");
        System.out.println("Result: " + customer2);

        System.out.println("\n--- Querying Customer 999 (Non-existent) ---");
        String customer3 = service.getCustomerName("999");
        System.out.println("Result: " + customer3);
    }
}

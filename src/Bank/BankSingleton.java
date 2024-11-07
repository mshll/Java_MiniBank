package Bank;

import java.util.ArrayList;
import java.util.List;

public class BankSingleton {
    private static BankSingleton instance;
    private final List<User> users;
    private final List<Employee> employees;

    private BankSingleton() {
        users = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public static BankSingleton getInstance() {
        if (instance == null) instance = new BankSingleton();
        return instance;
    }

    public User createUser(String username, String password) throws Exception {
        User newUser = new User(username, password);
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                throw new Exception("Username already exists");
            }
        }
        users.add(newUser);
        return newUser;
    }

    public Employee createEmployee(String id, String name, double salary, boolean admin) throws Exception {
        Employee newEmployee = new Employee(id, name, salary, admin);
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                throw new Exception("Employee already exists");
            }
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public User authenticate(String username, String password) {
        User authenticatedUser = null;

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                authenticatedUser = user;
            }
        }

        return authenticatedUser;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeeById(String id) {
        for (Employee employee : getEmployees()) {
            if (employee.getId().equals(id)) return employee;
        }
        return null;
    }

    public List<Employee> getAdmins() {
        List<Employee> employees = new ArrayList<>();

        for (Employee employee : getEmployees()) {
            if (employee.isAdmin()) employees.add(employee);
        }

        return employees;
    }
}

package Bank;

import java.util.ArrayList;
import java.util.List;

public class BankSingleton {
    private static BankSingleton instance;
    private final List<User> users;

    private BankSingleton() {
        users = new ArrayList<>();
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

    public User authenticate(String username, String password) {
        User authenticatedUser = null;

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                authenticatedUser = user;
            }
        }

        return authenticatedUser;
    }
}

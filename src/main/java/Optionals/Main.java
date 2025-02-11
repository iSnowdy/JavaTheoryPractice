package Optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Jose", "Pollença"); // User with information
        User user2 = new User(); // User with no information (null values)
        User user3 = null; // User completely null

        System.out.println("Creating Optionals...");

        Optional<User> user1Of = Optional.of(user1);
        Optional<User> user2Of = Optional.of(user2);
        try {
            Optional<User> user3Of = Optional.of(user3); // Will throw NPE
            System.out.println("Optional.of(user3): " + user3Of);
        } catch (NullPointerException e) {
            System.out.println("Error trying to create Optional of a null user");
        }
        System.out.println("Optional.of(user1): " + user1Of);
        System.out.println("Optional.of(user2): " + user2Of);


        Optional<User> user2Nullable = Optional.ofNullable(user2);
        System.out.println("Optional.of(user2 nullable): " + user2Nullable);
        Optional<User> user3Nullable = Optional.ofNullable(user3); // Can store null, but as empty
        System.out.println("Optional.ofNullable(user3 nullable): " + user3Nullable);

        System.out.println();
        System.out.println();

        System.out.println("Retrieving Optionals...");

        // Not recommended as it can throw exceptions
        try {
            System.out.println("Optional.of(user1): " + user1Of.get().getName());
            System.out.println("Optional.of(user2): " + user2Of.get().getName());
        } catch (NullPointerException e) {
            System.out.println("Error trying to get Optionals of a null user");
        }

        // Even though its empty, its not null
        System.out.println("Using orElse(): " + user2Nullable.orElse(new User(69, "Default User", "Address")).getName());
        // Since this is a null user, it will go inside the Else and print that Default User
        System.out.println("Using orElse(): " + user3Nullable.orElse(new User(69, "Default User", "Address")).getName());
        System.out.println();

        // Here we throw an exception (any) if it is null
        try {
            System.out.println("Using orElseThrow(): " + user3Nullable.orElseThrow(() -> new NullPointerException("Using orElseThrow()")));
        } catch (NullPointerException e) {
            System.out.println("From the orElseThrow");
        }
        System.out.println();

        user1Of.ifPresent(user -> System.out.println("With ifPresent" + user.getName()));
        // Even though it is null, it won't throw an exception because it only executes if not empty
        user3Nullable.ifPresent(user -> System.out.println("With ifPresent" + user.getName()));


        user1Of.ifPresentOrElse(
                user -> System.out.println("ifPresentOrElse() - User found: " + user.getName()),
                () -> System.out.println("ifPresentOrElse() - No user available"));
        user3Nullable.ifPresentOrElse(
                user -> System.out.println("ifPresentOrElse() - User found: " + user.getName()),
                () -> System.out.println("ifPresentOrElse() - No user available")
        );
    }
}

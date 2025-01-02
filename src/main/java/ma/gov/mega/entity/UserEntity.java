package ma.gov.mega.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Represents a User entity in the database with attributes such as first name, last name, email, and password.
 */
@Data // Generates getters, setters, toString, equals, and hashCode methods at compile time using Lombok.
@Entity // Marks this class as a JPA entity to map it to a database table.
@NoArgsConstructor // Generates a no-argument constructor using Lombok.
@AllArgsConstructor // Generates an all-argument constructor using Lombok.
@Table(
        name = "users", // Specifies the table name in the database as "users".
        uniqueConstraints = @UniqueConstraint(columnNames = "email") // Ensures that the "email" column is unique.
)
public class UserEntity {

    @Id // Marks this field as the primary key.
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatically generates a unique ID value.
    @Column(name = "userId") // Maps this field to the "userId" column in the database.
    private long id;

    @Column(nullable = false) // Specifies that this field cannot be null in the database.
    private String firstName; // Represents the user's first name.

    @Column(nullable = false) // Specifies that this field cannot be null in the database.
    private String lastName; // Represents the user's last name.

    @Column(nullable = false, unique = true) // Specifies that this field cannot be null and must be unique.
    @Email(message = "Please provide a valid email address.") // Validates the email format using Jakarta Validation.
    private String email; // Represents the user's email address.

    @Column(nullable = false) // Specifies that this field cannot be null in the database.
    @Size(
            min = 8,
            max = 30,
            message = "The password must be between 8 and 30 characters long."
    ) // Validates the password length.
    private String password; // Represents the user's password.

    @CreationTimestamp // Automatically sets the timestamp when the entity is created.
    @Column(nullable = false, updatable = false) // Field cannot be updated after creation.
    private LocalDateTime createdAt; // Stores the date and time of creation.

    @UpdateTimestamp // Automatically updates the timestamp whenever the entity is modified.
    private LocalDateTime updatedAt; // Stores the date and time of the last update.
}


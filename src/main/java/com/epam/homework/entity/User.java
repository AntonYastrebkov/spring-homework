package com.epam.homework.entity;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "not_users")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private String password;
    private String subscription;
    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.ORDINARY_USER;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(password, user.password) &&
                Objects.equals(subscription, user.subscription) &&
                Objects.equals(userRole, user.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phoneNumber, password, subscription, userRole);
    }

    @Override
    public String toString() {
        return "User: {id=" + id.toString() +
                " name=" + name + " email=" + email +
                " number=" + phoneNumber + "}";
    }
}
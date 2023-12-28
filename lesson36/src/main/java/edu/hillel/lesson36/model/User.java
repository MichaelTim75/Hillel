package edu.hillel.lesson36.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",
        joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;
}

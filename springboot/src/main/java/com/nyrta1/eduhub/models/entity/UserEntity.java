package com.nyrta1.eduhub.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString // TODO: REMOVE IT
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, max = 35, message = "The length of the name must be at least 4 characters and no more than 35 characters")
    private String name;

    @Size(min = 4, max = 35, message = "The length of the surname must be at least 4 characters and no more than 35 characters")
    private String surname;

    @Column(unique = true)
    @Size(min = 4, max = 35, message = "The length of the username must be at least 8 characters and no more than 35 characters")
    private String username;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_roles",
        joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "id")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id")
        })
    private List<Role> roles;
}

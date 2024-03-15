package com.nyrta1.eduhub.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 4, max = 35, message = "The length of the name must be at least 4 characters and no more than 35 characters")
    private String name;

    @Column(nullable = false)
    @Size(min = 4, max = 35, message = "The length of the surname must be at least 4 characters and no more than 35 characters")
    private String surname;

    @Column(nullable = false, unique = true)
    @Size(min = 4, max = 35, message = "The length of the username must be at least 4 characters and no more than 35 characters")
    private String username;

    @Column(nullable = false)
    private String password;

    // User's roles many-to-many table
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_roles",
        joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "id")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id")
        })
    private List<Role> roles;

    // Teacher's courses many-to-many table
    @NotNull
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "teachers_courses",
            joinColumns = {
                    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id")
            }
    )
    private List<Course> teacherCourses;

    // Student's courses many-to-many table
    @NotNull
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id")
            }
    )
    private List<Course> studentCourses;

    // One-to-many user's comments table
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

package com.nyrta1.eduhub.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 4, max = 35, message = "The length of the course title must be at least 4 characters and no more than 35 characters")
    private String title;
    private String description;
    private Float estimation = 0F; // By default 0.0
    private Long lessonCount = 0L; // By default 0 comments
    private Long price = 0L; // By default 0, it means the course is free

    // One-to-many for lessons
    @NotNull
    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Lesson> lessons = new ArrayList<>();

    // Teacher's courses many-to-many table
    @NotNull
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "teachers_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
            }
    )
    private List<UserEntity> courseOwners;

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
    private List<UserEntity> followerCourses;

    // Many-to-many for course topics
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "courses_topics",
            joinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "topic_id", referencedColumnName = "id")
            }
    )
    private List<Topic> topics = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

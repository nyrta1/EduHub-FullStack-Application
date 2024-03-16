package com.nyrta1.eduhub.repository;

import com.nyrta1.eduhub.models.dto.CourseDTO;
import com.nyrta1.eduhub.models.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT new com.nyrta1.eduhub.models.dto.CourseDTO(c.id, c.title, c.description, c.estimation, c.lessonCount, c.price) " +
            "FROM com.nyrta1.eduhub.models.entity.Course c")
    Page<CourseDTO> findCourse(Pageable pageable);
}

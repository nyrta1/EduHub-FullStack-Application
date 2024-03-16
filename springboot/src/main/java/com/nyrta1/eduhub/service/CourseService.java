package com.nyrta1.eduhub.service;

import com.nyrta1.eduhub.models.dto.CourseDTO;
import com.nyrta1.eduhub.models.dto.CoursesDTO;
import com.nyrta1.eduhub.models.entity.Course;

public interface CourseService {
    void save(CourseDTO courseDTO);
    CoursesDTO getCoursesByPagination(Integer page);
    // Update method
    void deleteById(Long id);
}

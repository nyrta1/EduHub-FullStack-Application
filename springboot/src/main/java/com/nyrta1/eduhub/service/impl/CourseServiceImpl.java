package com.nyrta1.eduhub.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nyrta1.eduhub.models.dto.CourseDTO;
import com.nyrta1.eduhub.models.dto.CoursesDTO;
import com.nyrta1.eduhub.models.entity.Course;
import com.nyrta1.eduhub.models.entity.UserEntity;
import com.nyrta1.eduhub.repository.CourseRepository;
import com.nyrta1.eduhub.repository.UserRepository;
import com.nyrta1.eduhub.service.CourseService;
import com.nyrta1.eduhub.utils.SessionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void save(CourseDTO courseDTO) {
        try {
            String currentSessionUsername = SessionUtil.getSessionUsername();
            UserEntity currentTeacherEntity = userRepository.findByUsername(currentSessionUsername)
                    .orElseThrow(() -> new IllegalStateException("User not found for username: " + currentSessionUsername));

            Course course = new Course();
            course.setTitle(courseDTO.getTitle());
            course.setDescription(courseDTO.getDescription());
            course.setPrice(courseDTO.getPrice());
            course.setCourseOwners(Collections.singletonList(currentTeacherEntity));
            courseRepository.save(course);
        } catch (Exception e) {
            throw new RuntimeException("Error saving course. Error: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional(readOnly = true) // To improve read data from db
    @Cacheable(value = "coursesCache", key = "'course_page' + #page", unless = "#result == null")
    public CoursesDTO getCoursesByPagination(Integer page) {
        try {
            int pageNo = page < 1 ? 0 : page - 1;
            Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.ASC, "createdAt");
            Page<CourseDTO> coursePage = courseRepository.findCourse(pageable);
            return new CoursesDTO(coursePage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            courseRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

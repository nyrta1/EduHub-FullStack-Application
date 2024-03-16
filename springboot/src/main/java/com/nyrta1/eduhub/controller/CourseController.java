package com.nyrta1.eduhub.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nyrta1.eduhub.models.dto.CourseDTO;
import com.nyrta1.eduhub.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getCoursesByPagination(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(courseService.getCoursesByPagination(page));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to read data from server. Error: " + e.getMessage());
        }
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDTO) {
        try {
            courseService.save(courseDTO);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Course created successfully!");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create course! Error: " + e.getMessage());
        }
    }
}

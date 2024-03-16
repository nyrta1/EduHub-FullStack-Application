package com.nyrta1.eduhub.models.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nyrta1.eduhub.models.entity.Lesson;
import com.nyrta1.eduhub.models.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private Float estimation;
    private Long lessonCount;
    private Long price = 0L;
    private List<Lesson> lessons = new ArrayList<>();
    private List<Topic> topics = new ArrayList<>();
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;

    public CourseDTO(Long id, String title, String description, Float estimation, Long lessonCount, Long price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.estimation = estimation;
        this.lessonCount = lessonCount;
        this.price = price;
    }
}

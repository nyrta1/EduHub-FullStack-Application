package com.nyrta1.eduhub.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDTO {
    private List<CourseDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public CoursesDTO(Page<CourseDTO> coursePage) {
        this.setData(coursePage.getContent());
        this.setTotalElements(coursePage.getTotalElements());
        this.setTotalPages(coursePage.getTotalPages());
        this.setCurrentPage(coursePage.getNumber() + 1);
        this.setFirst(coursePage.isFirst());
        this.setLast(coursePage.isLast());
        this.setHasNext(coursePage.hasNext());
        this.setHasPrevious(coursePage.hasPrevious());
    }
}

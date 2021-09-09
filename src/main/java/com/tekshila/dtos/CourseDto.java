package com.tekshila.dtos;

import lombok.Getter;
import lombok.Setter;
import com.tekshila.domain.enums.Status;
import java.util.Date;

@Getter @Setter
public class CourseDto {

    private String name;
    private String description;
    private String category;
    private Status status;
    private int createdBy;

}

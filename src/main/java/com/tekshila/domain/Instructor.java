package com.tekshila.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.tekshila.domain.enums.Status;

import java.util.Date;

@Setter
@Getter
@Document(collection = "instructor")
public class Instructor {
    @Id
    private ObjectId _id;

    private long instructorId;
    private String name;
    private String description;
    private String category;
    private Status status;
    private Date createDate;

}

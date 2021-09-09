package com.tekshila.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter @Setter
@Document(collection = "enrolled_courses")
public class EnrolledCourse implements Serializable {

    @Id
    private ObjectId _id;

    private String userIdentity;
    private String courseId;
    private String status;

}

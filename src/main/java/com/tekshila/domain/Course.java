package com.tekshila.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.tekshila.domain.enums.Status;

import java.io.Serializable;
import java.util.Date;

@Setter @Getter @ToString
@Document(collection = "courses")
public class Course implements Serializable {

    @Id
    private ObjectId _id;

    private long courseId;
    private String name;
    private String description;
    private String category;
    private Status status;
    private Date createDate;
    private int createdBy;

    private String test;
    private String test2;
    private String shortDesc;
    private String percentComplete;
    private String ratingCount;
    private String rating;
    private int userIdentity;

}

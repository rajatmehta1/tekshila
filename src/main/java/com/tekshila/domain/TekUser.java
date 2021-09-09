package com.tekshila.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@Document(collection = "users")
public class TekUser implements Serializable {

    @Id
    private ObjectId _id;

    private int userId;
    private String name;
    private String email;
    private String username;
    private String password;
    private String description;
    private String is_instructor;
//    private String isTeacher;

}

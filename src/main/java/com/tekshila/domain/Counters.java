package com.tekshila.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class Counters {
    @Id
    private ObjectId _id;

    private String sequenceName;
    private int sequenceValue;
}

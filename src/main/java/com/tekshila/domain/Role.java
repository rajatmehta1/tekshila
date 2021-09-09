package com.tekshila.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@Document(collection = "roles")
public class Role {
    @Id
    public String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    public String role;
}

package com.projects.backend.rutube2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    @JsonIgnore
    private Date createdDate = new Date();

    @Column(name = "updated_date")
    @JsonIgnore
    private Date updatedDate = new Date();

}

package com.dcorp.hightech.acounts.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * @MappedSuperClass:
 * To indicate to spring data JPA that this class is going act as a superclass for
 * all entities
 **/
@Getter
@Setter
@ToString
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {

    @Column(updatable = false)
    LocalDateTime createdAt;

    @Column(updatable = false)
    String createdBy;

//    insert table = false: To say to spring don't populate or update columns whenever it is trying
//    to insert a new record
    @Column(insertable = false)
    LocalDateTime updatedAt;

    @Column(insertable = false)
    String updatedBy;
}

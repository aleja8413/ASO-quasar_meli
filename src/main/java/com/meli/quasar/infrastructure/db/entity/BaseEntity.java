package com.meli.quasar.infrastructure.db.entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
})
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

}

package com.meli.quasar.infrastructure.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Satellite")
public class SatelliteDboEntity extends BaseEntity {

    private String name;
    private float distance;

    @Type(type = "string-array")
    @Column(
            columnDefinition = "ARRAY"
    )
    private String[] message;


}

package com.meli.quasar.infrastructure.db.entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
})
@Table(name = "Satellite")
public class SatelliteDboEntity {

    @Id
    private String name;

    private float distance;

    @Type(type = "string-array")
    @Column(
            columnDefinition = "ARRAY"
    )
    private String[] message;


}

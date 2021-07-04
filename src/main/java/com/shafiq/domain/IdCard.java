package com.shafiq.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "id_card")
public class IdCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String code = UUID.randomUUID().toString();

    @OneToOne(mappedBy = "idCard")
    private Person person;

}

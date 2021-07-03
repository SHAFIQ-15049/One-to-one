package com.shafiq.domain;

import com.shafiq.enumeration.Gender;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/*

Bidirectional OneToOne Mapping example

In unidirectional association, the source entity has a relationship field that refers
to the target entity and the source entity’s table contains the foreign key.
In a bidirectional association, each entity (i.e. source and target) has a relationship
field that refers to each other and the target entity’s table contains the foreign key.
The source entity must use the mappedBy attribute to define the bidirectional one-to-one mapping.

 */



@Data
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15)
    @Column(name = "phone_num")
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dob;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


}

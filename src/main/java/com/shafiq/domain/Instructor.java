package com.shafiq.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/*

Unidirectional OneToOne Mapping example
Here, Instructor is the Source entity and UserProfile is the target entity.
As InstructorDetails is source entity and it is the owner entity so it  contains
JoinColumn to reserve the foreign key

 */

@Data
@Entity
@Table(name = "instructor")
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(max = 60)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 60)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(name="email")
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_details")
    private InstructorDetails instructorDetails;
}

package com.shafiq.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/*

Bidirectional OneToOne Mapping example
Here, User is the Source entity and UserProfile is the target entity.
As User is source entity and it is the owner entity so it contains mappedBy.
UserProfile is the target entity so for bidirectional mapping it contains
JoinColumn to reserve the foreign key

 */



@Data
@Entity
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 65)
    @Column(name="first_name")
    private String firstName;

    @Size(max = 65)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;


    @NotNull
    @Size(max = 128)
    private String password;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
    private UserProfile userProfile;

}

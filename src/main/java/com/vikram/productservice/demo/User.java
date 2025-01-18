package com.vikram.productservice.demo;

import jakarta.persistence.*;

@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@Entity( name = "st_user")
@DiscriminatorColumn(
        name = "userType",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue( value = "0" )
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

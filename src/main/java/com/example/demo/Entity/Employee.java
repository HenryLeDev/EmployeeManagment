package com.example.demo.Entity;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    private boolean onVacation;

    public Employee(String firstName, String lastName, String email, boolean onVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.onVacation = onVacation;
    }

}

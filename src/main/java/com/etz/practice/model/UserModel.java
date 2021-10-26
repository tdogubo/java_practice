package com.etz.practice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class UserModel {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName="user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    private String firstName;
    private String lastName;
    private String course;

    public UserModel(String firstName, String lastName, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
            this.course = course;
        }

    public UserModel() {

    }

    @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", course='" + course + '\'' +
                    '}';
        }
    }



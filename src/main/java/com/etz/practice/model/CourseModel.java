package com.etz.practice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class CourseModel {
    @Id
    @SequenceGenerator(name = "course_sequence",
    sequenceName = "course_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "course_sequence")
    private Long id;
    private String title;
    private int unit;

    public CourseModel(Long id, String title, int unit) {
        this.id = id;
        this.title = title;
        this.unit = unit;

    }

    public CourseModel() {

    }
    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    };
}

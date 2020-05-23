package br.com.kesley.jobextra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    private Curriculum curriculum;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Institution institution;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseStatusEnum status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseDurationEnum duration;

    @ManyToOne
    private CourseType type;

}
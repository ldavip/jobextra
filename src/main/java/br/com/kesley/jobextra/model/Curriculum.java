package br.com.kesley.jobextra.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Curriculum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToOne
    private Person person;

    @Column(length = 3000)
    private String summary;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "curriculum")
    private List<Course> courses = new ArrayList<>();

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "curriculum")
    private List<JobExperience> jobExperiences = new ArrayList<>();

}
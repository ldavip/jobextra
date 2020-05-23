package br.com.kesley.jobextra.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person extends User {

    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate birthday;

    @OneToOne(mappedBy = "person")
    private Curriculum curriculum;

    @OneToMany(mappedBy = "pk.person")
    private Set<Application> applications = new HashSet<>();

    public Person() {
        super(UserCategoryEnum.INDIVIDUAL);
    }

}
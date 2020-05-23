package br.com.kesley.jobextra.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Company extends User {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<Job> jobs = new ArrayList<>();

    public Company() {
        super(UserCategoryEnum.CORPORATE);
    }

}
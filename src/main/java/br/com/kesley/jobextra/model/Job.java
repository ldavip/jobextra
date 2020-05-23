package br.com.kesley.jobextra.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate jobDay;

    private String description;

    private Double value;

    @Enumerated(EnumType.STRING)
    private JobStatusEnum jobStatus;

    @ManyToOne
    private Company owner;

    @OneToOne
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "pk.job")
    private Set<Application> applications = new HashSet<>();

    public void apply(Person person) {
        applications.add(new Application(this, person));
    }

}
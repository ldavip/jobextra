package br.com.kesley.jobextra.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.kesley.jobextra.model.Job;
import br.com.kesley.jobextra.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ApplicationPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
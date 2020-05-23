package br.com.kesley.jobextra.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.kesley.jobextra.model.pk.ApplicationPK;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Id
    private ApplicationPK pk = new ApplicationPK();

    @Enumerated(EnumType.STRING)
    private ApplicationStatusEnum status = ApplicationStatusEnum.ANALYZING;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date = Instant.now();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant updateDate;

    public Application() {
    }

    public Application(Job job, Person person) {
        pk.setJob(job);
        pk.setPerson(person);
    }

    public void setJob(Job job) {
        pk.setJob(job);
    }

    public Job getJob() {
        return pk.getJob();
    }

    public void setPerson(Person person) {
        pk.setPerson(person);
    }

    @JsonIgnore
    public Person getPerson() {
        return pk.getPerson();
    }

}
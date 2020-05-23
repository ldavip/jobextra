package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.model.Application;
import br.com.kesley.jobextra.model.pk.ApplicationPK;

public interface ApplicationRepository extends JpaRepository<Application, ApplicationPK> {

}
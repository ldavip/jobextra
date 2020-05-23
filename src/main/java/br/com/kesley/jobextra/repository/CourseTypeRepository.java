package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.model.CourseType;

public interface CourseTypeRepository extends JpaRepository<CourseType, Integer> {

}
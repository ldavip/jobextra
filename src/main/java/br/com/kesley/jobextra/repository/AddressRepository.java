package br.com.kesley.jobextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kesley.jobextra.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
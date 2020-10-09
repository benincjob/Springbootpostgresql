package com.benin.sprigbootpostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benin.sprigbootpostgresql.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}

package com.cg.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.vegetable.module.VegetableDTO;

@Repository
public interface IVegetableRepository extends JpaRepository<VegetableDTO, Integer>{

}

package com.cg.vegetable.repository;

/**
 * User Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Vegetable;

@Repository
public interface IVegetableRepository extends JpaRepository<Vegetable, Integer> {

	@Query("select c from Vegetable c where c.name=:name")
	public List<Vegetable> findVegetableByName(@Param("name") String name);

	@Query("select c from Vegetable c where c.type=:type")
	public List<Vegetable> findVegetableList(@Param("type") String type);

	public Vegetable save(Cart dbcart);

}

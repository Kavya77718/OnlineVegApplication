package com.cg.vegetable.repository;

/**
* User Repository interface extends
* {@link org.springframework.data.jpa.repository.JpaRepository}.
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vegetable.module.Cart;
import com.cg.vegetable.module.Vegetable;

@Repository

public interface ICartRepository extends JpaRepository<Cart, Integer> {

	Cart save(Vegetable v);

}

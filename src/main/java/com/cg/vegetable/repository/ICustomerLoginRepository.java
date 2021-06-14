package com.cg.vegetable.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.cg.vegetable.module.CustomerLogin;
	@Repository
	public interface ICustomerLoginRepository extends JpaRepository<CustomerLogin, String> {
		

	}


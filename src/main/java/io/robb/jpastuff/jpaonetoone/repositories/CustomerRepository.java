package io.robb.jpastuff.jpaonetoone.repositories;

import io.robb.jpastuff.jpaonetoone.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

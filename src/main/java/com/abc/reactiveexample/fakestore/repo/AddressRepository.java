package com.abc.reactiveexample.fakestore.repo;

import com.abc.reactiveexample.fakestore.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}

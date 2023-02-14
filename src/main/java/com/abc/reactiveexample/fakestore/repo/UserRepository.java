package com.abc.reactiveexample.fakestore.repo;

import com.abc.reactiveexample.fakestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

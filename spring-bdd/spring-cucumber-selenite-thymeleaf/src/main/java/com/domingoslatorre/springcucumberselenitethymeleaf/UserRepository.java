package com.domingoslatorre.springcucumberselenitethymeleaf;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

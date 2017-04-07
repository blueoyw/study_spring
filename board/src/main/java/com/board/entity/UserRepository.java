package com.board.entity;

import org.springframework.data.repository.CrudRepository;


//이것은 Repository I/F 이다. 이것은 Spring 내에서 자동적으로 구현될 것이다. bean 이름은 userRepository가 된다.
public interface UserRepository extends CrudRepository<User, Long> {

}

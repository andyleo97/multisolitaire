package com.andyleo.multisolitaire.Repositories;

import com.andyleo.multisolitaire.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmailAndPassword(String email, String password);

    @Override
    <S extends User> S save(S entity);

//    @Override
//    <S extends User> S saveAndFlush(S entity);
}

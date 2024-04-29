package com.four_bro.deliverium.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.four_bro.deliverium.model.*;;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByUsernameAndPassword(String username, String password);

    List<UserModel> findByRole(Integer role);

}

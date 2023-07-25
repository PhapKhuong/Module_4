package com.blog_security.repository.account;

import com.blog_security.model.account.AppUser;
import com.blog_security.query.AccountQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<AppUser, String> {
    @Query(value = AccountQuery.SELECT_USER_BY_ID, nativeQuery = true)
    AppUser findUserById(@Param("username") String username);
}

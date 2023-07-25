package com.account.repository;

import com.account.model.UserRole;
import com.account.model.key.KeyUserRole;
import com.account.query.AccountQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, KeyUserRole> {
    @Query(value = AccountQuery.SELECT_USER_ROLE_BY_ID, nativeQuery = true)
    List<String> findRoleNameById(@Param("ur.username") String username);
}

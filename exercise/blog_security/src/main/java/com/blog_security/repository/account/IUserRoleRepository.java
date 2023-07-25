package com.blog_security.repository.account;

import com.blog_security.model.account.UserRole;
import com.blog_security.model.account.key.KeyUserRole;
import com.blog_security.query.AccountQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, KeyUserRole> {
    @Query(value = AccountQuery.SELECT_USER_ROLE_BY_ID, nativeQuery = true)
    List<String> findRoleNameById(@Param("ur.username") String username);

    @Query(value = AccountQuery.INSERT_USER_ROLE,nativeQuery = true)
    void createUserRole(@Param("role_id") int roleId,
                        @Param("username") String username);
}

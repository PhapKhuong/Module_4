package com.blog_security.repository.account;

import com.blog_security.model.account.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<AppRole, Integer> {
}

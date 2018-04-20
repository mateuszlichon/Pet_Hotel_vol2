package com.pethotel.repository;

import com.pethotel.entity.UserRole;
import com.pethotel.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    UserRole findByRole(Role role);
}

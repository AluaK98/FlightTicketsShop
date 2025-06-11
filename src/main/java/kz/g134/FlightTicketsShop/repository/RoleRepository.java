package kz.g134.FlightTicketsShop.repository;

import kz.g134.FlightTicketsShop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("select r from Role r where r.name='ROLE_USER'")
    Role findRoleUser();
}

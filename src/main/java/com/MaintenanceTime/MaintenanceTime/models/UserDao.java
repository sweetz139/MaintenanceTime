package com.MaintenanceTime.MaintenanceTime.models;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserDto, Integer> {
    public boolean findByEmail(String email);
}

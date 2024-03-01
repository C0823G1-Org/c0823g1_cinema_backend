package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role,Long> {
    @Query(value ="select * from role where id = :id" ,nativeQuery = true)
    Role findById(@Param("id")int id);
}

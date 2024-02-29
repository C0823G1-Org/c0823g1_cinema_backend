package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Role;
import com.example.c0823g1_movie_backend.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RolesRepository rolesRepository;
    @Override
    public Role findById(int id) {
        return rolesRepository.findById(id);
    }
}

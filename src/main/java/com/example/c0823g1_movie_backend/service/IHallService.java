package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.IHallDTO;
import com.example.c0823g1_movie_backend.model.Hall;

public interface IHallService extends IGeneralService<Hall> {
    IHallDTO findById(Long id);
}

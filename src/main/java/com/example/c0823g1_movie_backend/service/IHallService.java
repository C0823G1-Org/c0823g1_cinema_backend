package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.model.Hall;
import org.springframework.data.repository.query.Param;

public interface IHallService extends IGeneralService<Hall> {
    HallDTO findById(Long id);
    Hall getHallById( Long id);

}

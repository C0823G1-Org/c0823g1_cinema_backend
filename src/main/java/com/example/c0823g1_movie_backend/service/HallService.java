package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.dto.HallDTO;
import com.example.c0823g1_movie_backend.model.Hall;
import com.example.c0823g1_movie_backend.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallService implements IHallService{
    @Autowired
    HallRepository hallRepository;
    @Override
    public Hall save(Hall hall) {
        return null;
    }

    public Hall create(Hall hall) {
        return null;
    }

    @Override
    public HallDTO findById(Long id) {
        return hallRepository.findHallById(id);
    }

    @Override
    public Hall getHallById(Long id) {
        return hallRepository.getHallById(id);
    }
}

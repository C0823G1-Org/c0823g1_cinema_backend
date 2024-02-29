package com.example.c0823g1_movie_backend.service;

import com.example.c0823g1_movie_backend.model.Hall;

public interface IGeneralService<T> {
    T save(T t);
    T create(T t);
}

package com.example.c0823g1_movie_backend.service;

public interface IGeneralService<T> {
    T save(T t);
    T create(T t);
}

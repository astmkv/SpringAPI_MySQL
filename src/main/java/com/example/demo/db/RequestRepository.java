package com.example.demo.db;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RequestRepository extends CrudRepository <Request,Integer> {


    Optional<Request> findByName(String name);

    @Override
    default Optional<Request> findById(Integer integer) {
        return Optional.empty();
    }
}

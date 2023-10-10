package com.akindev.library.repositories;

import com.akindev.library.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Author, Integer> { }

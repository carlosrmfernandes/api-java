package com.dasafio.api.domain.repository;

import com.dasafio.api.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorInterface extends JpaRepository<Author, Integer> {
    Author findFirstByNome(String name);

}

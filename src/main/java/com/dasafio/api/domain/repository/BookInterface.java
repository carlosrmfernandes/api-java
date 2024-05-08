package com.dasafio.api.domain.repository;

import com.dasafio.api.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInterface extends JpaRepository<Book, Integer> {
}

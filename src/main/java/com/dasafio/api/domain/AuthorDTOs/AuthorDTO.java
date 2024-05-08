package com.dasafio.api.domain.AuthorDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuthorDTO {

    private String nome;
    private List<BookDTO> books;

}

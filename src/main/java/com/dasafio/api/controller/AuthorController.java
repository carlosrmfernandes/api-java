package com.dasafio.api.controller;

import com.dasafio.api.domain.AuthorDTOs.AuthorDTO;

import com.dasafio.api.domain.AuthorDTOs.BookDTO;
import com.dasafio.api.domain.entity.Book;
import com.dasafio.api.domain.exception.Erros;
import com.dasafio.api.domain.exception.TestException;
import com.dasafio.api.domain.repository.BookInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dasafio.api.domain.entity.Author;
import com.dasafio.api.domain.repository.AuthorInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    private AuthorInterface authorInterface;

    @Autowired
    private BookInterface bookInterface;

    @PostMapping("/authors")
//    public Author book(@RequestBody AuthorDTO authorDTO) {
    public ResponseEntity book(@RequestBody AuthorDTO authorDTO) {
        Author author = new Author();
        author.setNome(authorDTO.getNome());
        Author newAuthor = authorInterface.save(author);

//        Optional<Author> oneAuthor = authorInterface.findById(newAuthor.getId());

//        Optional<Author> oneAuthor = Optional.ofNullable(authorInterface.findFirstByNome("Milton"));

        List<Author> allAuthor = authorInterface.findAll();
        List<Author> arrayList = new ArrayList<>();

        for (Author a: allAuthor){
            if(a.getNome().equals("carlos")){
                arrayList.add(a);
            }

        }
        if(arrayList.get(0)!= null){
            System.out.println(arrayList.get(0).getNome());
        }


//        if(true){
//            throw new TestException("Erro");
//        }

        List<Book> books = authorDTO.getBooks().stream().map(dto -> {
            Book book = new Book();
            book.setAuthors(newAuthor);
            book.setDescription(dto.getDescription());
            return book;
        }).collect(Collectors.toList());

        bookInterface.saveAll(books);

        newAuthor.setBook(books);
        return ResponseEntity.status(HttpStatus.OK).body(newAuthor);
        //return newAuthor;

    }

    @GetMapping("/")
    public String nome() {
        return "Carlos";
    }
}

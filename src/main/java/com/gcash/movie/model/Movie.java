package com.gcash.movie.model;

import jakarta.annotation.Resource;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.gcash.movie.model.Role;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity //mark class as entity
@Table
public class Movie {

    @Column //defining id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer yearReleased;

    @Column
    private boolean isSequel;

    @Column
    @Enumerated(EnumType.STRING)
    private List<Genre> genre;

    @Column
    private List<String> castList;

    public List<Genre> getGenre() {
        return genre;
    }
}

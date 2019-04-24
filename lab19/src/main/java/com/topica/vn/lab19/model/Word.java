package com.topica.vn.lab19.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@Table

public class Word {
    public Word(){};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @Column
    private String word;

    @Column(columnDefinition = "text")
    private String meaning;
}

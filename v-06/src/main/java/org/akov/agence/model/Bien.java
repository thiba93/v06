package org.akov.agence.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bien")
@Data
public class Bien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // null

    private String titre;
    private String photo;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int prix; // 0
    private boolean visible;


}

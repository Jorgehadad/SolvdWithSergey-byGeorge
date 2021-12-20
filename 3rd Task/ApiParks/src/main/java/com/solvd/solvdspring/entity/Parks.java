package com.solvd.solvdspring.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Parks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String NameP;

    @CreationTimestamp
    private LocalDateTime Date_creation;
    
    

    
}
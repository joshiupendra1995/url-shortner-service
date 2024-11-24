package com.url_shortner.service.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String shortUrl;

    @Column(nullable = false)
    private String longUrl;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime expiryDate;
}


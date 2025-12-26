package com.anwar.aicodereview.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "code_submission")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    private String fileName;
    private String language;

    @Column(columnDefinition = "TEXT")
    private String code;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

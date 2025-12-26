package com.anwar.aicodereview.repository;


import com.anwar.aicodereview.model.CodeSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CodeSubmissionRepository extends JpaRepository<CodeSubmission, UUID> {
    List<CodeSubmission> findByUserId(UUID userId);
}

package com.anwar.aicodereview.service;


import com.anwar.aicodereview.model.CodeSubmission;
import com.anwar.aicodereview.repository.CodeSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CodeService {

    @Autowired
    private CodeSubmissionRepository submissionRepository;
    public CodeSubmission createSubmission(CodeSubmission codeSubmission){
        CodeSubmission saved=submissionRepository.save(codeSubmission);
        return saved;
    }
}

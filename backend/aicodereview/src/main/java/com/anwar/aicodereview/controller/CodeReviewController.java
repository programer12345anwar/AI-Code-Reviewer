package com.anwar.aicodereview.controller;


import com.anwar.aicodereview.model.CodeSubmission;
import com.anwar.aicodereview.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
public class CodeReviewController {

    @Autowired
    private CodeService codeService;

    @PostMapping("/upload")
    public ResponseEntity<CodeSubmission> uploadCode(@RequestBody CodeSubmission codeSubmission){
        System.out.println(codeSubmission);

        return ResponseEntity.ok(codeService.createSubmission(codeSubmission));
    }
}

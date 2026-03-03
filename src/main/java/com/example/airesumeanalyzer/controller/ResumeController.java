package com.example.airesumeanalyzer.controller;
import com.example.airesumeanalyzer.services.RessumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ResumeController {
    @Autowired
    private RessumeService ressumeService;
    @GetMapping("/hello")
    public String hello(){
        return "AI resume Analyzer Running ";
    }

    @PostMapping("/upload")
    public Map<String,Object>uploadAndAnalyze(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()) {
            return Map.of("error","No file uploaded !");
        }
        String filename=file.getOriginalFilename();
        return ressumeService.analyzeResume(file);
    }


}

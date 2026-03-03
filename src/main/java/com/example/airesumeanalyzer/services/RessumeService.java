package com.example.airesumeanalyzer.services;
import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import  java.util.Map;
@Service
public class RessumeService {
    public Map<String, Object>analyzeResume(MultipartFile file){
        Map<String, Object> result=new HashMap<>();
        try{
            PDDocument document=PDDocument.load(file.getInputStream());
            PDFTextStripper pdfStripper=new PDFTextStripper();
            String text=pdfStripper.getText(document).toLowerCase();
            document.close();
            text=text.replaceAll("\\s+"," ");
            List<String> skills= Arrays.asList("java","python","sql","spring boot","react","angular","ai","machine learning","html"
,"css","javascript");
            List<String> detectedSkills=new ArrayList<>();
            for (String skill:skills) {
                if (text.contains(skill)) {
                    detectedSkills.add(skill);
                }
            }
            int score = (int) ((double)detectedSkills.size()/skills.size()*100);
            String recommendation;
            if (score>=70) {
                recommendation = "Strong candidate for backend / frontend /AI roles";
            }
            else if (score>=40) {
                recommendation="Good candidate, but consider improving some skills";
            }
            else {
                recommendation="Candidate needs skill improvement";
            }

            result.put("file",file.getOriginalFilename());
            result.put("skills",detectedSkills);
            result.put("score",score);
            result.put("recommendation", recommendation);
        }
        catch (IOException e){
            e.printStackTrace();
            result.put("error","Failed to process resume");
        }
        return result;
    }
}

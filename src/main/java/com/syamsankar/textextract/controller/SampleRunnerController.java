package com.syamsankar.textextract.controller;


import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
@EnableAutoConfiguration
public class SampleRunnerController {

    @RequestMapping("/")
    @ResponseBody
    public String sayHello() {
        return "................. Welcome to TextExtract!!!";
    }

    @RequestMapping("/ocr")
    @ResponseBody
    public String doOCR() {
        try {
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("/home/syam/ResearchAndDevelopment/tessdata");
            return tesseract.doOCR(new File("/home/syam/ResearchAndDevelopment/SampleImages/P0006.png"));
        }catch (Exception e){
            System.out.println(e);
            return "Error";
        }
    }
}

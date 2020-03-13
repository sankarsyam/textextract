package com.syamsankar.textextract.controller;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
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

    @RequestMapping("/ocrhelp")
    @ResponseBody
    public String moreOCR() {
        File imageFile = new File("/home/syam/ResearchAndDevelopment/SampleImages/P0006.png");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        instance.setDatapath("/home/syam/ResearchAndDevelopment/tessdata"); // path to tessdata directory

        try {
            String result = instance.doOCR(imageFile);
            return result;
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return "Error ";
    }
}

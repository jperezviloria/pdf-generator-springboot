package com.pdfmaker.generator.service;

import com.pdfmaker.generator.sevice.PdfMaker;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PdfMaker_test {

    @Autowired
    PdfMaker pdfMaker;

    @Test
    void generatePdf_test() throws IOException {
        pdfMaker.generatePdf();
    }
}

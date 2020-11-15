package com.pdfmaker.generator.sevice;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class PdfMaker {


    public void generatePdf() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        page.setRotation(90);


        document.addPage(page);
        PDPageContentStream pdPageContentStream = new PDPageContentStream(document,page);

        pdPageContentStream.beginText();
        pdPageContentStream.setFont(PDType1Font.TIMES_BOLD, 12);
        pdPageContentStream.newLineAtOffset(20, page.getMediaBox().getHeight()-52);
        pdPageContentStream.showText("Hello World");
        pdPageContentStream.endText();

        PDImageXObject image = PDImageXObject.createFromFile("/home/protobot/certificateImage.png", document);
        pdPageContentStream.drawImage(image, 0, 0, image.getWidth() / 2, image.getHeight() / 2);


        pdPageContentStream.close();

        document.save("/home/protobot/pdfjava.pdf");

    }

}



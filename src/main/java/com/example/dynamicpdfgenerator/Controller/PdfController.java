package com.example.dynamicpdfgenerator.Controller;

import com.example.dynamicpdfgenerator.Entity.Items;
import com.example.dynamicpdfgenerator.Entity.PdfEntity;
import com.example.dynamicpdfgenerator.util.PdfGenerator;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PdfController {

    @GetMapping("/generatePDF")
    public void generatePDFfile(@RequestBody PdfEntity pdfEntity, HttpServletResponse response) throws DocumentException, IOException{
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headerValue = "attachment; fileName=ItemsList" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headerValue);
        List<Items> itemsList = pdfEntity.getItemsList();
        PdfGenerator generator = new PdfGenerator();
        generator.generate(pdfEntity, itemsList, response);
    }
}

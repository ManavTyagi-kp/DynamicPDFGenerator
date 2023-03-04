package com.example.dynamicpdfgenerator.util;

import com.example.dynamicpdfgenerator.Entity.Items;
import com.example.dynamicpdfgenerator.Entity.PdfEntity;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PdfGenerator {
    public void generate(PdfEntity pdfEntity, List<Items> items, HttpServletResponse response) throws DocumentException, IOException{
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);

        PdfPTable table1 = new PdfPTable(2);
        table1.setWidthPercentage(100);
        table1.setWidths(new int[] {3,3});

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(CMYKColor.WHITE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);


        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.BLACK);

        Paragraph paragraph2 = new Paragraph("Seller:"+"\n"+pdfEntity.getSeller()+"\n"+pdfEntity.getSellerAddress()+"\n"+"GSTIN: "+pdfEntity.getSellerGstin(), font);
        cell.addElement(paragraph2);
        cell.setPadding(20);
        table1.addCell(cell);

        Paragraph paragraph3 = new Paragraph("Buyer:"+"\n"+pdfEntity.getBuyer()+"\n"+pdfEntity.getBuyerAddress()+"\n"+"GSTIN: "+pdfEntity.getBuyerGstin(), font);

        //Table2 for item list
        PdfPTable table2 = new PdfPTable(4);
        table2.setWidthPercentage(100);
        table2.setWidths(new int[] {3,3,3,3});
        table2.setSpacingBefore(0);

        cell.setPadding(5);
        cell.setPhrase(new Phrase("Item", font));
        table2.addCell(cell);
        cell.setPhrase(new Phrase("Quantity", font));
        table2.addCell(cell);
        cell.setPhrase(new Phrase("Rate", font));
        table2.addCell(cell);
        cell.setPhrase(new Phrase("Amount", font));
        table2.addCell(cell);

        for(Items items1: items){
            table2.addCell(items1.getItemName());
            table2.addCell(String.valueOf(items1.getQuantity()));
            table2.addCell(String.valueOf(items1.getRate()));
            table2.addCell(String.valueOf(items1.getAmount()));
        }

        cell.addElement(paragraph3);
        cell.setPadding(20);
        table1.addCell(cell);

        document.add(table1);
        document.add(table2);

        document.close();
    }
}

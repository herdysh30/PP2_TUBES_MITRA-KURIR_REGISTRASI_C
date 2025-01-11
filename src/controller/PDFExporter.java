package controller;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PDFExporter {

    public static void exportTableToPDF(String filePath,String titleText, List<String[]> tableData, String[] columnHeaders) throws DocumentException, IOException {
        // Buat dokumen PDF
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Tambahkan judul
        Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph(titleText, titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(Chunk.NEWLINE);

        // Tambahkan tabel
        PdfPTable table = new PdfPTable(columnHeaders.length);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Tambahkan header kolom
        for (String header : columnHeaders) {
            PdfPCell cell = new PdfPCell(new Phrase(header));
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }

        // Tambahkan data baris
        for (String[] row : tableData) {
            for (String cellData : row) {
                table.addCell(cellData);
            }
        }

        document.add(table);
        document.close();
    }
}


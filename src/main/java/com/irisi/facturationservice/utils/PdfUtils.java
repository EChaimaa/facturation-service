package com.irisi.facturationservice.utils;

import com.irisi.facturationservice.app.dto.FactureDto;
import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.domain.pojo.ProjetMemberPojo;
import com.irisi.facturationservice.infra.proxy.ProjetProxy;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class PdfUtils {

    @SneakyThrows
    public static byte[] generatePdf(FacturePojo facturePojo,  List<ProjetMemberPojo> projetMembers) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        //PdfWriter.getInstance(document, new FileOutputStream("iTextImageExample.pdf"));
        PdfWriter pd = PdfWriter.getInstance(document, baos);
        document.open();
        document.setPageSize(PageSize.A4);
        addTitle(document);
        addInvoiceReference(document, facturePojo.getReference());
        addLine(document);
        addTableHeader(document, facturePojo.getClientRef(),facturePojo.getProjectRef(), facturePojo.getStatus(),facturePojo.getDateFacture());
        addOrderAmount(document, facturePojo.getTotal());

        addOrderItemsTable(document, projetMembers);
        document.close();
        return baos.toByteArray();
    }

    @SneakyThrows
    private static void addTitle(Document document) {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD, BaseColor.ORANGE);
        Phrase phrase = new Phrase("Facture", font);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorderWidth(0);
        cell.setPaddingBottom(40);
        table.addCell(cell);
        document.add(table);
    }

    @SneakyThrows
    private static void addInvoiceReference(Document document, String refrence) {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
        Phrase phrase = new Phrase("FACTURE : " + refrence, font);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorderWidth(0);
        cell.setPaddingBottom(20);
        table.addCell(cell);
        document.add(table);
    }

    @SneakyThrows
    private static void addOrderAmount(Document document, double amount) {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.setSpacingBefore(20);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
        Phrase phrase = new Phrase("Total : " + amount + " dhs", font);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorderWidth(0);
        cell.setPaddingBottom(20);
        table.addCell(cell);
        document.add(table);
    }

    @SneakyThrows
    private static void addLine(Document document) {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.setSpacingAfter(20);
        table.setPaddingTop(20);
        PdfPCell cell = new PdfPCell(new Phrase(""));
        cell.setBackgroundColor(new BaseColor(252, 153, 24));
        cell.setBorderWidth(0);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setFixedHeight(4);
        table.addCell(cell);
        document.add(table);
    }

    @SneakyThrows
    private static void addTableHeader(Document document, String refClient, String refProjet, String status, Date dateFacture) {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setPaddingTop(50);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
        Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
        PdfPTable tableHeader = new PdfPTable(4);
        tableHeader.setWidthPercentage(100);
        tableHeader.setSpacingAfter(20);
        tableHeader.setPaddingTop(20);
        PdfPCell numeroClientTitle = new PdfPCell(new Phrase("REF  :", font2));
        numeroClientTitle.setBorderWidth(0);
        numeroClientTitle.setMinimumHeight(30);
        PdfPCell numeroClient = new PdfPCell(new Phrase(refClient, font));
        numeroClient.setBorderWidth(0);
        numeroClient.setHorizontalAlignment(Element.ALIGN_LEFT);
        numeroClient.setMinimumHeight(30);
        PdfPCell adresseTitle = new PdfPCell(new Phrase("Projet :", font2));
        adresseTitle.setBorderWidth(0);
        adresseTitle.setMinimumHeight(30);
        PdfPCell adresse = new PdfPCell(new Phrase(refProjet, font));
        adresse.setHorizontalAlignment(Element.ALIGN_LEFT);
        adresse.setBorderWidth(0);
        adresse.setMinimumHeight(30);
        PdfPCell telephoneTitle = new PdfPCell(new Phrase("Statut :", font2));
        telephoneTitle.setBorderWidth(0);
        telephoneTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell telephone = new PdfPCell(new Phrase(status, font));
        telephone.setHorizontalAlignment(Element.ALIGN_RIGHT);
        telephone.setBorderWidth(0);
        telephone.setMinimumHeight(30);
        PdfPCell dateTitle = new PdfPCell(new Phrase("Date :", font2));
        dateTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
        dateTitle.setBorderWidth(0);
        dateTitle.setMinimumHeight(30);
        PdfPCell date = new PdfPCell(new Phrase(dateFacture.toString(), font));
        date.setHorizontalAlignment(Element.ALIGN_RIGHT);
        date.setBorderWidth(0);
        date.setMinimumHeight(30);
        table.addCell(numeroClientTitle);
        table.addCell(numeroClient);
        table.addCell(dateTitle);
        table.addCell(date);
        table.addCell(adresseTitle);
        table.addCell(adresse);
        table.addCell(telephoneTitle);
        table.addCell(telephone);
        document.add(table);
    }

    @SneakyThrows
    private static void addOrderItemsTable(Document document, List<ProjetMemberPojo> orderItemDtos) {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        addOrderItemsHeaderTable(table);
        if (orderItemDtos.size() > 0) {
            orderItemDtos.forEach(orderItemDto -> addOrderItemsContentTable(table, orderItemDto));
        }
        document.add(table);
    }

    @SneakyThrows
    private static void addOrderItemsHeaderTable(PdfPTable table) {
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.WHITE);
        Stream.of("Employé", "Salaire/heure", "Heures de travail", "Total").forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(new BaseColor(85, 132, 172));
            header.setBorderWidth(.6f);
            header.setBorderColor(BaseColor.WHITE);
            header.setPadding(10);
            header.setPhrase(new Phrase(columnTitle, font));
            table.addCell(header);
        });
    }

    @SneakyThrows
    private static void addOrderItemsContentTable(PdfPTable table, ProjetMemberPojo orderItemDto) {
        Font font = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.BLACK);
        Stream.of(orderItemDto.getEmploye().getNom()+" "+ orderItemDto.getEmploye().getPrenom(), orderItemDto.getEmploye().getCategorie().getSalaireParHeure(), orderItemDto.getNbrHeures(), orderItemDto.getNbrHeures() * orderItemDto.getEmploye().getCategorie().getSalaireParHeure()).forEach(columnTitle -> {
            PdfPCell cell = new PdfPCell();
            cell.setPhrase(new Phrase(String.valueOf(columnTitle), font));
            cell.setBorderWidth(.6f);
            cell.setBorderColor(BaseColor.WHITE);
            cell.setPadding(10);
            cell.setBorderColor(new BaseColor(234, 234, 234));
            table.addCell(cell);
        });
    }
}


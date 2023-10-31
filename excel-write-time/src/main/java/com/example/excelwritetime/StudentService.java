package com.example.excelwritetime;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentService {

    private final StudentRepo studentRepo;

    public void exportToExcel() throws IOException {
        List<Student> data = studentRepo.findAll();
        try (SXSSFWorkbook workbook = new SXSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Reporting Trial Data");
            long startTime = System.nanoTime();

            int rowNumber = 0;
            Row headerRow = sheet.createRow(rowNumber++);
            headerRow.createCell(0).setCellValue("Id");
            headerRow.createCell(1).setCellValue("FirstName");
            headerRow.createCell(2).setCellValue("MiddleName");
            headerRow.createCell(3).setCellValue("LastName");
            headerRow.createCell(4).setCellValue("Address");
            headerRow.createCell(5).setCellValue("Phone Number");
            headerRow.createCell(6).setCellValue("Emergency Contact Number");
            headerRow.createCell(7).setCellValue("Emergency Contact Name");
            headerRow.createCell(8).setCellValue("Married Status");
            headerRow.createCell(9).setCellValue("Gender");
            headerRow.createCell(10).setCellValue("Caste");
            headerRow.createCell(11).setCellValue("Nationality");
            headerRow.createCell(12).setCellValue("CitizenshipNumber");
            headerRow.createCell(13).setCellValue("Profile Pic Url");
            headerRow.createCell(14).setCellValue("Personal Email");
            headerRow.createCell(15).setCellValue("EC Relationship");

            for (Student student : data) {
                    Row row = sheet.createRow(rowNumber++);
                    row.createCell(0).setCellValue(student.getId());
                    row.createCell(1).setCellValue(student.getFirstName());
                    row.createCell(2).setCellValue(student.getMiddleName());
                    row.createCell(3).setCellValue(student.getLastName());
                    row.createCell(4).setCellValue(student.getAddress());
                    row.createCell(5).setCellValue(student.getPhoneNumber());
                    row.createCell(6).setCellValue(student.getEmergencyContactNumber());
                    row.createCell(7).setCellValue(student.getEmergencyContactName());
                    row.createCell(8).setCellValue(student.getMarriedStatus());
                    row.createCell(9).setCellValue(student.getGender());
                    row.createCell(10).setCellValue(student.getCaste());
                    row.createCell(11).setCellValue(student.getNationality());
                    row.createCell(12).setCellValue(student.getCitizenshipNumber());
                    row.createCell(13).setCellValue(student.getProfilePicUrl());
                    row.createCell(14).setCellValue(student.getPersonalEmail());
                    row.createCell(15).setCellValue(student.getEcRelationShip());
            }
            try (FileOutputStream fileOut = new FileOutputStream("reportingTrial_data.xlsx")) {
                    workbook.write(fileOut);
            }
            long endTime = System.nanoTime();
            long totalTimeTakenNano = endTime - startTime;
            double totalTimeTakenMillis = (double) totalTimeTakenNano / 1_000_000;

            log.info("Time Taken: " + totalTimeTakenMillis + " milliseconds");
            }
        }
}

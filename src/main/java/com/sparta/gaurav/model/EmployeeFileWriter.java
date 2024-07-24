package com.sparta.gaurav.model;

import com.sparta.gaurav.model.EmployeeDTO;

import java.io.*;


public class EmployeeFileWriter {

    public static void writeEntryToFile(String filePath, EmployeeDTO employeeDTO, String type) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedWriter.write(employeeDTO.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            LoggerClass.logError(e.getMessage());
        }
    }
}
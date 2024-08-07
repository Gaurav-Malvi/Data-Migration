package com.sparta.gaurav.controller;

import com.sparta.gaurav.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class EmployeeFileReader {



    private static final HashMap<String, EmployeeDTO> employeeRecords = new HashMap<>();

    public static void readFromCSVAndWriteToDatabase(String filePath) {

        HashMap<String, EmployeeDTO> employeeRecords = new HashMap<>();
        String line;
        EmployeeDAO employeeDAO = new EmployeeDAO();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                populateHashMap(line);
            }
            employeeDAO.persistToDB(employeeRecords);
        } catch (IOException e) {
            LoggerClass.logError("Reading CSV failed: " + e.getMessage());
        } catch (NullPointerException e) {
            LoggerClass.logError("Thread Null Pointer: " + e.getMessage());
        }

    }

    private static void populateHashMap(String line){
        String[] record = line.trim().split(",");
        EmployeeDTO employeeDTO = new EmployeeDTO(record);
        if(DataValidation.isRecordValid(record)) {
            if(!employeeRecords.containsKey(record[0])) {
                employeeRecords.put(record[0], employeeDTO);
            } else{
                EmployeeFileWriter.writeEntryToFile("resources/duplicateValues.csv", employeeDTO, "duplicate");
            }
        } else{
            EmployeeFileWriter.writeEntryToFile("resources/invalidValues.csv", employeeDTO, "invalid");
        }
    }

}

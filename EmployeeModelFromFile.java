/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphdemo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angeliquerivera
 */
public class EmployeeModelFromFile {
     // Path to the text file containing Employee data
        private static String TXT_FILE_PATH = "src/main/resources/Data.txt";
        private static final List<Employee> employees;
        
    //INITIALIZE
    static {
            employees = loadEmployees();
    }

    //LOADS EMPLOYEE DATA
    public static List<Employee> loadEmployees() {
        //INITIALIZES NEW OBJECT ARRAY LIST
        List<Employee> employees = new ArrayList<>();
        
        //TRIES TO OPEN AND LOAD TXT DATA THEN CLOSING RIGHT AFTER BY USING TRY-CATCH
        try (BufferedReader reader = new BufferedReader(new FileReader(TXT_FILE_PATH))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                
                List<String> employeeData = parseTxtLine(currentLine);
                if (employeeData.size() >= 19) { // Assuming you expect 19 fields
                    Employee employee = new Employee(employeeData.toArray(new String[0]));
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;      // This Return the list of loaded Employee objects

    }
    
    //PARSE STRING SURROUNDED WITH QUOTATION MARKS WITH COMMAS INSIDE IT
    private static List<String> parseTxtLine(String line) {
        List<String> tokens = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder buffer = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes; // Toggle the inQuotes flag
            } else if (c == ',' && !inQuotes) {
                // End of a token
                tokens.add(buffer.toString());
                buffer = new StringBuilder(); // Reset buffer
            } else {
                buffer.append(c);
            }
        }
        // Add the last token, if any
        if (buffer.length() > 0) {
            tokens.add(buffer.toString());
        }
        return tokens;
    }      

    /**
     * @return the employees
     */
    public static List<Employee> getEmployeeModelList(){
        return employees;
    }

    /** Set the path to the text file containing Employee data
     *  @param aTXT_FILE_PATH the TXT_FILE_PATH to set
     */
    public static void setTXT_FILE_PATH(String aTXT_FILE_PATH) {
        TXT_FILE_PATH = aTXT_FILE_PATH;
    }
}

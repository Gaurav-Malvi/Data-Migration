package com.sparta.gaurav.controller;


public class Starter {

    public static void start(){
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.initialize();
        SelectionManager.startSelection();
    }

}

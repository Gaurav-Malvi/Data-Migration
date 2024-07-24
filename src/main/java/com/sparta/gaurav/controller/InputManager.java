package com.sparta.gaurav.controller;

import java.util.Scanner;


public class InputManager {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        return scanner.nextInt();
    }

    public static String getString() {
        return scanner.nextLine();
    }
}

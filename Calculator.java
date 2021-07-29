package com.JWD04;

import java.util.Scanner;

public class Calculator {

    private double firstOperand;
    private double secondOperand;
    private int operationType;
    private double result;
    private boolean success;


    public static void main(String[] args) {
        System.out.println("Welcome to this primitive calculator");
        boolean process = true,exit=false, isCorrectOpType=false;
        Calculator calc = new Calculator();



        while(process){
            menu();
            isCorrectOpType=calc.selectOperation();
            if(isCorrectOpType) {
                exit=calc.operationExecution(calc);
            }
            if(!exit&&calc.success){
                System.out.println(calc.result);
                System.out.println("_________________________");
                calc.success=false;
            } else if (exit) process=false;

        }
    }

    private boolean operationExecution(Calculator calc) {
      boolean exit=false;
      switch (this.operationType){
          case 1: {calc.Addition(); break;}
          case 2: {calc.Subtraction(); break;}
          case 3: {calc.Multiplication(); break;}
          case 4: {calc.Division(); break;}
          case 5: {calc.Exponentiation(); break;}
          case 6: {calc.RootExtraction(); break;}
          case 7: {exit=true; break;}
          default:{
              System.out.println("Unknown operation");
              System.out.println("________________");
              calc.success=false;
              return false;}
      }
      return exit;
    }
    private void RootExtraction() {

    }
    private void Exponentiation() {

    }
    private void Division() {
        inputOperands();
        if (this.success) {
            this.result = this.firstOperand / this.secondOperand;
        }
    }
    private void Multiplication() {
        inputOperands();
        if (this.success) {
            this.result = this.firstOperand * this.secondOperand;
        }
    }
    private void Subtraction() {
        inputOperands();
        if (this.success) {
            this.result = this.firstOperand - this.secondOperand;
        }
    }
    private void Addition() {
        inputOperands();
        if (this.success) {
            this.result = this.firstOperand + this.secondOperand;
        }
    }
    private boolean selectOperation() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Select an operation from the menu.");
            this.operationType = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            System.out.println("You have selected an operation that is not listed.");
            System.out.println("_____________________");
            return false;
        }
        return true;
    }
    private void inputOperands() {
       Scanner scanner = new Scanner(System.in);
        this.success=false;
        while (!this.success) {
            try {
                System.out.println("Input values for the operation. Ex: value1 value2");
                this.firstOperand = Double.parseDouble(scanner.next());
                this.secondOperand = Double.parseDouble((scanner.next()));
                this.success = true;
            } catch (Exception e2) {
                System.out.println("You entered not numbers. The calculator can only work with numbers");
                this.success = false;
                scanner.nextLine();

            }
            if (this.operationType == 4 && this.secondOperand == 0) {
                System.out.println("Division by zero. Unfeasible operation");
                this.success = false;
            }

            System.out.println("_____________________");
        }

    }
    private static void menu() {
        System.out.println("Calculator functions:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Root extraction");
        System.out.println("7. Exit");
        System.out.println("________________________");

    }
}

package com.JWD04;

import java.util.Scanner;

public class Calculator {

    private int firstOperand;
    private int secondOperand;
    private int operationType;


    public static void main(String[] args) {
        System.out.println("Welcome to this primitive calculator");
        boolean process = true, correctInput=true;
        double result=0;
        Calculator calc = new Calculator();


        while(process){
            menu();.
            correctInput=calc.selectOperation();
            if(correctInput){
                result=calc.operationExecution();
                System.out.println(result);
                System.out.println("_________________________");
            }


        }
    }

    private double operationExecution() {
        double result=0;
      switch (this.operationType){
          case 1: {result=this.firstOperand+this.secondOperand; break;}
          case 2: {result=this.firstOperand-this.secondOperand; break;}
          case 3: {result=this.firstOperand*this.secondOperand; break;}
          case 4: {result=this.firstOperand/this.secondOperand; break;}
          case 5: {}
          case 6: {}
          default: System.out.println("Неверная операция"); return -1;
      }
      return result;
    }


    private boolean selectOperation() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Select an operation from the menu.");
            this.operationType = Integer.parseInt(scanner.next()) ;
        } catch (Exception e) {
            System.out.println("You have selected an operation that is not listed.");
            System.out.println("_____________________");
            return false;
        }

        try {
            System.out.println("Input values for the operation. Ex: value1 value2");
            this.firstOperand = Integer.parseInt(scanner.next());
            this.secondOperand = Integer.parseInt((scanner.next()));
        }catch (Exception e2){
            System.out.println("You entered not numbers. The calculator can only work with numbers");
            System.out.println("_____________________");
            return false;
        }
        if (this.operationType==4 && this.secondOperand==0) {
            System.out.println("Division by zero. Unfeasible operation");
            System.out.println("_____________________");
            return false;
        }
        System.out.println("_____________________");
        return true;
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

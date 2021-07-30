package com.JWD04;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Calculator {

    private double firstOperand;
    private double secondOperand;
    private int operationType;
    private double result;
    private boolean success;


    public static void main(String[] args) {
        System.out.println("Welcome to this primitive calculator :)");
        boolean process = true, isExitSelected = false, isCorrectOpType = false;
        Calculator calc = new Calculator();


        while (process) {
            menu();
            isCorrectOpType = calc.selectOperation();
            if (isCorrectOpType) {                         //если с типом операции все гуд
                isExitSelected = calc.operationExecution();       //выполняем ее
            }
            if (!isExitSelected && calc.success) {                             //выполнение прошло успешно и выход из проги не требуется
                System.out.println(calc.result);
                System.out.println("_________________________");
                calc.success = false;
            } else if (isExitSelected) process = false;         //Вите нужно выйти

        }
    }

    private boolean operationExecution() {
        boolean exit = false;
        switch (operationType) {
            case 1: {
                addition();
                break;
            }
            case 2: {
                subtraction();
                break;
            }
            case 3: {
                multiplication();
                break;
            }
            case 4: {
                division();
                break;
            }
            case 5: {
                exponentiation();
                break;
            }
            case 6: {
                rootExtraction();
                break;
            }
            case 7: {
                exit = true;
                break;
            }
            default: {
                System.out.println("Unknown operation");
                System.out.println("________________");
                success = false;        //введенной операции не существует
                return false;
            }             // выходим в меню
        }
        return exit;
    }

    private void rootExtraction() {
        System.out.println("InputExample for 9^(1/2): 9 2");
        inputOperands();
        while (firstOperand < 0) {
            System.out.println("You cannot use a negative number in this operation :/");
            inputOperands();
        }
        double index = 1.0 / secondOperand;
        result = pow(firstOperand, index);

    }

    private void exponentiation() {
        System.out.println("InputExample for 9^2: 9 2");
        inputOperands();
        while (firstOperand==0)
        {
            System.out.println("This is mathematical uncertainly. You want too much from me!");
            inputOperands();
        }
        result = pow(firstOperand, secondOperand);
    }

    private void division() {
        System.out.println("InputExample for 9/3: 9 3");
        inputOperands();
        while (secondOperand == 0) {
            System.out.println("Division by zero. Unfeasible operation");
            inputOperands();
        }
        result = firstOperand / secondOperand;

    }

    private void multiplication() {
        System.out.println("InputExample for 5*2: 5 2");
        inputOperands();
        result = firstOperand * secondOperand;
    }

    private void subtraction() {
        System.out.println("InputExample for 10-8: 10 8");
        inputOperands();
        result = firstOperand - secondOperand;
    }

    private void addition() {
        System.out.println("InputExample for 10+8: 10 8");
        inputOperands();
        result = firstOperand + secondOperand;
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
        success = false;
        while (!success) {
            try {
                System.out.println("Input values for the operation:");
                firstOperand = Double.parseDouble(scanner.next());
                secondOperand = Double.parseDouble((scanner.next()));
                success = true;
            } catch (Exception e2) {
                System.out.println("You entered not numbers. The calculator can only work with numbers :(");
                success = false;
                scanner.nextLine();
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

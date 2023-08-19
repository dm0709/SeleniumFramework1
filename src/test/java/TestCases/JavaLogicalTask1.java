package TestCases;

import java.util.Scanner;

public class JavaLogicalTask1 {

    public static void main(String[] args) {

        //int income = 10000;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your income: ");
        int income = myObj.nextInt();


        if (income >=0 && income<=10275){
            System.out.println("your tax will be 10%");
        }
        else if (income>10275 && income<=41775){
            System.out.println("your tax will be 12%");
        }
        else if (income>41775 && income<=89075){
            System.out.println("your tax will be 22%");
        }
        else {
            System.out.println("please call your CPA");
        }

    }
}

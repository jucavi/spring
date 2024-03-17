package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        CalculatorService calculator = context.getBean("calculatorService", CalculatorService.class);
        System.out.println(calculator.holaMundo());

        InvoiceService invoice = context.getBean("invoiceService", InvoiceService.class);
        System.out.println(invoice.getCalculator().holaMundo());
    }
}

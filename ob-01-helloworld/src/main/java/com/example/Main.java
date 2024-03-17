package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        // EJEMPLO 1
        // Opción 1: Crear un objeto de forma normal
        //CalculatorService cs = new CalculatorService();

        // CONCEPTO 1: Obtener beans de spring

        // Opción 2: Recibir un objeto de Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println(context.containsBean("calculatorService"));

        CalculatorService calculatorService = context.getBean("calculatorService", CalculatorService.class);
        System.out.println(calculatorService.holaMundo());

        //Se puede volver a obtener
        // OJO: Se recupera el mismo objeto
        // Solo ejecuta el constructor una vez
        CalculatorService calculatorService1 = context.getBean("calculatorService", CalculatorService.class);
        System.out.println(calculatorService1.holaMundo());

        // CONCEPTO 2: Cargar un bean desde otro bean
        
        // EJEMPLO 2
        GestorFacturas gestorFacturas = context.getBean("gestorFacturas", GestorFacturas.class);
        System.out.printf(gestorFacturas.getCalculatorService().holaMundo());

        // CONCEPTO 3: Scope o alcance
        // Los bean por defecto son singleton, se crea un objeto y se reutiliza en toda la aplicación
        // Se puede cambiar a scope="prototype" si queremos que se cree un objeto cada vez

    }
}


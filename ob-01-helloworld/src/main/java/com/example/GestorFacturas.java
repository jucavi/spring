package com.example;

public class GestorFacturas {

    private CalculatorService calculatorService;
    private String nombre;

    public GestorFacturas(CalculatorService calculatorService, String nombre) {
        System.out.println("Ejecuntando constructor Gestor de Facturas");
        this.calculatorService = calculatorService;
        this.nombre = nombre;
    }

    public CalculatorService getCalculatorService() {
        return calculatorService;
    }

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

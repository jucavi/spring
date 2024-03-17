package com.example;

import org.springframework.stereotype.Component;

@Component
public class InvoiceService {
    private CalculatorService calculator;

    public InvoiceService(CalculatorService calculator) {
        this.calculator = calculator;
    }

    public CalculatorService getCalculator() {
        return calculator;
    }

    public void setCalculator(CalculatorService calculator) {
        this.calculator = calculator;
    }
}

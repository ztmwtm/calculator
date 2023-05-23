package calculator.calculator.service;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {

    int sum(String first, String second);

    int diff(String first, String second);

    int multiply(String first, String second);

    int div(String first, String second);
}


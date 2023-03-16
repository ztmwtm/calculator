package calculator.calculator;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {

    int sum(int first, int second);

    int diff(int first, int second);

    int multiply(int first, int second);

    double div(int first, int second);
}


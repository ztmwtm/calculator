package calculator.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public int sum(int first, int second) {
        return first + second;
    }

    public int diff(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public double div(int first, int second) {
        return first * 1. / second;
    }
}

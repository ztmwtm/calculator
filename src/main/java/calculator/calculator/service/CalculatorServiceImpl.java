package calculator.calculator.service;

import calculator.calculator.exception.ZeroArgumentException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int sum(String first, String second) {
        return Integer.parseInt(first) + Integer.parseInt(second);
    }

    @Override
    public int diff(String first, String second) {
        return Integer.parseInt(first) - Integer.parseInt(second);
    }

    @Override
    public int multiply(String first, String second) {
        return Integer.parseInt(first) * Integer.parseInt(second);
    }

    @Override
    public int div(String first, String second) {
        if (Integer.parseInt(second) == 0) {
            throw new ZeroArgumentException("Division by 0 is not allowed");
        }
        return Integer.parseInt(first) / Integer.parseInt(second);
    }
}

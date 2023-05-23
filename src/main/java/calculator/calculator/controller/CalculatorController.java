package calculator.calculator.controller;

import calculator.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(path = {"", "/"})
    public String greetings()  { return
        "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String sum(@RequestParam(required = false, name = "num1") String first,
                      @RequestParam(required = false, name = "num2") String second) {

        int result = calculatorService.sum(first, second);

        return String.format("%s + %s = %d", first, second, result);
    }

    @GetMapping(path = "/minus")
    public String diff(@RequestParam(required = false, name = "num1") String first,
                       @RequestParam(required = false, name = "num2") String second) {

        int result = calculatorService.diff(first, second);

        return String.format("%s - %s = %d", first, second, result);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(required = false, name = "num1") String first,
                           @RequestParam(required = false, name = "num2") String second) {

        int result = calculatorService.multiply(first, second);

        return String.format("%s * %s = %d", first, second, result);
    }

    @GetMapping(path = "/divide")
    public String div(@RequestParam(required = false, name = "num1") String first,
                      @RequestParam(required = false, name = "num2") String second) {

        int result = calculatorService.div(first, second);

        return String.format("%s / %s = %d", first, second, result);
    }
}

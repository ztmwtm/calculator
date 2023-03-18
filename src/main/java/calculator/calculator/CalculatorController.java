package calculator.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    private final String CSSSTYLE = """
                    <!DOCTYPE html>
                           <html>
                           
                           <head>
                               <meta charset="UTF-8" />
                               <title>Calculator</title>
                               <style>
                               body {
                                   display: flex;
                                   height: 100vh;
                                   background: silver;
                               }
                               h1 {
                                   color: white;
                                   margin: auto;
                                   font-size: 40px;
                                   font-family: Georgia, serif;
                                   background: silver;
                                   align: center;
                                   text-shadow: 1px 1px 2px black;
                               }
                               #calculator {
                                   margin: auto;
                                   padding: 20px;
                                   background: silver;
                                   box-shadow: 0 0 10px black;
                                   border-radius: 10px;
                               }
                               </style>
                           </head>
            """;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(path = {"", "/"})
    public String greetings() {
        return CSSSTYLE + "<h1>HELLO TO CALCULATOR</h1>";
    }

    @GetMapping(path = "/plus")
    public String sum(@RequestParam(required = false, name = "num1") String first,
                      @RequestParam(required = false, name = "num2") String second) {
        int firstInt;
        int secondInt;

        //Not sure is good practise =\\ No idea how to move validation to another method

        try {
            firstInt = Integer.parseInt(first);
            secondInt = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            return CSSSTYLE + """
                    <h1>Sorry, you input wrong params</h1>
                    """;
        }

        int result = calculatorService.sum(firstInt, secondInt);

        return CSSSTYLE + String.format("<h1> %d + %d = %d </h1>", firstInt, secondInt, result);
    }

    @GetMapping(path = "/minus")
    public String diff(@RequestParam(required = false, name = "num1") String first,
                       @RequestParam(required = false, name = "num2") String second) {
        int firstInt;
        int secondInt;

        try {
            firstInt = Integer.parseInt(first);
            secondInt = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            return CSSSTYLE + """
                    <h1>Sorry, you input wrong params</h1>
                    """;
        }

        int result = calculatorService.diff(firstInt, secondInt);

        return CSSSTYLE + String.format("<h1> %d - %d = %d </h1>", firstInt, secondInt, result);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(required = false, name = "num1") String first,
                           @RequestParam(required = false, name = "num2") String second) {
        int firstInt;
        int secondInt;

        try {
            firstInt = Integer.parseInt(first);
            secondInt = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            return CSSSTYLE + """
                    <h1>Sorry, you input wrong params</h1>
                    """;
        }

        int result = calculatorService.multiply(firstInt, secondInt);

        return CSSSTYLE + String.format("<h1> %d * %d = %d </h1>", firstInt, secondInt, result);
    }

    @GetMapping(path = "/divide")
    public String div(@RequestParam(required = false, name = "num1") String first,
                      @RequestParam(required = false, name = "num2") String second) {
        int firstInt;
        int secondInt;

        try {
            firstInt = Integer.parseInt(first);
            secondInt = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            return CSSSTYLE + """
                    <h1>Sorry, you input wrong params</h1>
                    """;
        }

        double result = calculatorService.div(firstInt, secondInt);

        if (result == Double.NEGATIVE_INFINITY || result == Double.POSITIVE_INFINITY)
            return CSSSTYLE + """
                    <h1>Sorry, division by zero is not allowed</h1>
                    """;

        return CSSSTYLE + String.format("<h1> %d / %d = %.2f </h1>", firstInt, secondInt, result);
    }
}

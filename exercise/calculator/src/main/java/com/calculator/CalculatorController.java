package com.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("")
    public String showForm() {
        return "home";
    }

    @PostMapping("/show-result")
    public ModelAndView doCalculator(
            @RequestParam int firstNumber, @RequestParam int secondNumber,
            @RequestParam String operation, ModelAndView mv) {
        mv.setViewName("home");
        int result = 0;
        try {
            switch (operation) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "x":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                default:
                    showForm();
            }
        } catch (ArithmeticException e) {
            String errorMsg = "The second number must be different 0!";
            mv.addObject("error", errorMsg);
            return mv;
        }
        mv.addObject("result", result);
        return mv;
    }
}

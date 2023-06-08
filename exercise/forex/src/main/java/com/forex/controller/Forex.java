package com.forex.controller;

import com.forex.model.Money;
import com.forex.service.IMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Forex {
    @Autowired
    private IMoneyService moneyService;

    @GetMapping("/forex")
    public String showList(Model model) {
        List<Money> monies = moneyService.display();
        model.addAttribute("monies", monies);
        return "forex/input";
    }

    @PostMapping("/convert")
    public String doCConvert(
            @RequestParam("quantity") String quantity, @RequestParam("idFrom") String idFrom,
            @RequestParam("idTo") String idTo, Model model) {

        Money fromMoney = moneyService.search(Integer.parseInt(idFrom));
        Money toMoney = moneyService.search(Integer.parseInt(idTo));

        float radio = (float) fromMoney.getValue() / (float) toMoney.getValue();

        float result = radio * Integer.parseInt(quantity);

        String resultStr = quantity + " " + fromMoney.getName() + " = " + result + " " + toMoney.getName();

        model.addAttribute("result", resultStr);
        return "forex/result";
    }
}

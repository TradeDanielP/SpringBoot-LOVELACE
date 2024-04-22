package com.riwi.operations.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operations.entities.Operation;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {

    @PostMapping("/sum")
    public String sum(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();


        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @PostMapping("/min")
    public String min(@RequestBody Operation objOperation){
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @PostMapping("/plus")
    public String plus(@RequestBody Operation objOperation) {
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @PostMapping("/div")
    public String div(@RequestBody Operation objOperation) {
        int num1 = objOperation.getNum1();
        int num2 = objOperation.getNum2();

        if (num2 == 0) {
            return "el segundo numero no puede ser 0";
        }

        return num1 + " / " + num2 + " = " + (num1 / num2);
    }
    
    
}

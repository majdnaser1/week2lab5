package com.example.employeescontrollar;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v2/employee")
public class employeeControllar {
    ArrayList<employee> employeeslist =new ArrayList<>();



    @GetMapping
    public ArrayList getCustomer(){

        return employeeslist;
    }


    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid employee e, Errors errors){
       if (errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new employeemassege(message,400));
    }
        employeeslist.add(e);
        return ResponseEntity.status(201).body(new employeemassege("new add user",201));
    }


    @PutMapping("/{index}")
    public ResponseEntity updateUser(@PathVariable  int index, @RequestBody @Valid employee e, Errors errors){
            if (errors.hasErrors()){
                String message=errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new employeemassege(message,400));
            }
        employeeslist.set(index,e);
        return ResponseEntity.status(201).body(new employeemassege("list updated",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteuser(@PathVariable int index, Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new employeemassege(message, 400));
        }

        employeeslist.remove(index);
        return ResponseEntity.status(201).body(new employeemassege("list deleted",201));
    }


}

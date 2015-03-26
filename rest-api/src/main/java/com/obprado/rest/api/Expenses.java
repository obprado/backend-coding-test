package com.obprado.rest.api;

import com.obprado.rest.api.json.Expense;
import java.util.*;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author omar
 */
@Controller
@RequestMapping("/expenses")
public class Expenses {
    private static final Collection<Expense> fake_expenses = new ArrayList<>();
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Collection<Expense> getExpenses(){
        return fake_expenses;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addExpense(@RequestBody Expense expense){
        fake_expenses.add(expense);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }        
    
}

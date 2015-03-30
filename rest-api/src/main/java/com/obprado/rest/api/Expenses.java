package com.obprado.rest.api;

import com.obprado.relational.persistence.ExpenseDAO;
import com.obprado.rest.api.json.JsonExpense;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static final Collection<JsonExpense> fake_expenses = new ArrayList<>();
    private ExpenseDAO dao;
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Collection<JsonExpense> getExpenses(){
        return fake_expenses;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addExpense(@RequestBody JsonExpense expense){
        fake_expenses.add(expense);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }        

    @Autowired    
    public void setDao(ExpenseDAO dao) {
        this.dao = dao;
    }
    
}

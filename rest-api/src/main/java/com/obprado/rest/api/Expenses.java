package com.obprado.rest.api;

import com.obprado.model.Expense;
import com.obprado.relational.persistence.ExpenseDAO;
import com.obprado.rest.api.json.JsonExpense;
import com.obprado.usecase.*;
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
        Collection<JsonExpense> jsonExpenses = new ArrayList<>();
        Collection<Expense> expenses = new ListExpenses(dao).fetch();
        for (Expense expense : expenses)
            jsonExpenses.add(new JsonExpense(expense));
        return jsonExpenses;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addExpense(@RequestBody JsonExpense jsonExpense){
        AddExpense addExpense = new AddExpense(dao);
        addExpense.add(jsonExpense.toExpense());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }        

    @Autowired    
    public void setDao(ExpenseDAO dao) {
        this.dao = dao;
    }
    
}

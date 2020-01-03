package com.mapri.webbackend.controller;

import com.mapri.webbackend.domain.Budget;
import com.mapri.webbackend.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("budget")
public class BudgetController {

    @Autowired
    BudgetRepository budgetRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Budget> findAll (){
        return budgetRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Budget save (@RequestBody Budget budget){
        Budget savedBudget = budgetRepository.save(budget);
        return savedBudget;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void remove(@RequestBody Budget budget){
        budgetRepository.deleteById(budget.getId());
    }
}

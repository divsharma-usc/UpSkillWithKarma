package com.noobHack.karma.controller;

import com.noobHack.karma.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Operator")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @PutMapping("/{cId}/{party}")
    @ResponseBody
    public String addObserver(@PathVariable String cId, @PathVariable String party) {
        return operatorService.addObserver(cId, party);
    }
}
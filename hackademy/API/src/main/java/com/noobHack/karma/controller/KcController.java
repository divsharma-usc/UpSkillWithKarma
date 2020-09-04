package com.noobHack.karma.controller;

import com.noobHack.karma.service.KCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/KC")
public class KcController {

    @Autowired
    private KCService kcService;

    @GetMapping("/{psid}/{cId}/{party}")
    @ResponseBody
    public String approveKC(@PathVariable String psid, @PathVariable String cId, @PathVariable String party) {
        return kcService.approveKC(psid, cId, party);
    }
}

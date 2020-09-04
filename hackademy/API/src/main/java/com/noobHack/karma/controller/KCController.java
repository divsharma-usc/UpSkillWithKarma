package com.noobHack.karma.controller;

import com.noobHack.karma.service.KCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/KC")
public class KCController {

    @Autowired
    private KCService kcService;

    @PutMapping("/{psid}/{cId}/{party}")
    @ResponseBody
    public String approveKC(@PathVariable String psid, @PathVariable String cId, @PathVariable String party) {
        return kcService.approveKC(psid, cId, party);
    }
}

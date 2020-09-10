package com.noobHack.karma.controller;

import com.noobHack.karma.service.KarmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/Karma")
public class KarmaController {
    @Autowired
    KarmaService karmaService;

    @RequestMapping("/{id}")
    @CrossOrigin
    @ResponseBody
    public String getKarmas(@PathVariable String id) {
        return karmaService.getKarma(id);
    }
}

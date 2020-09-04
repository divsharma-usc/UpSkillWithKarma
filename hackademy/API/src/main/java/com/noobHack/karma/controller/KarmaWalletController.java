package com.noobHack.karma.controller;

import com.noobHack.karma.service.KarmaWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/KarmaWallet")
public class KarmaWalletController {

    @Autowired
    private KarmaWalletService karmaWalletService;

    @PutMapping("/{id}/{party}/{cId}")
    @ResponseBody
    public String getKarmas(@PathVariable String id, @PathVariable String party, @PathVariable String cId) {
        return karmaWalletService.spendKarmaWallet(id, party, cId);
    }

    @GetMapping("/{id}/{party}/{cId}")
    @ResponseBody
    public String Karmas(@PathVariable String id, @PathVariable String party) {
        return karmaWalletService.getKarmaWallet(id, party);
    }

    @GetMapping("silverCoins/{id}/{party}")
    @ResponseBody
    public String getSilverKarmas(@PathVariable String id, @PathVariable String party) {
        return karmaWalletService.geSilvertKarmaWallet(id, party);
    }
}
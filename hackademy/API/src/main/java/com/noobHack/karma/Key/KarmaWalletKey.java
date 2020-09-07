package com.noobHack.karma.Key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KarmaWalletKey implements Key {
    private String provider;
    private String psid;
    private String walletType;
}

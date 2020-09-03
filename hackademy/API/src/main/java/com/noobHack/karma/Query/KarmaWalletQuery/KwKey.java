package com.noobHack.karma.Query.KarmaWalletQuery;

import hackademy.wallet.lang.WalletId;
import hackademy.wallet.lang.WalletType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KwKey {
    private String provider;
    private String psid;
    private String walletType;
}

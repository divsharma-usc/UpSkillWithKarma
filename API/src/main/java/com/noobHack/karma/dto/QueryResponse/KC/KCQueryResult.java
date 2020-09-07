package com.noobHack.karma.dto.QueryResponse.KC;

import com.noobHack.karma.Key.KCKey;;
import lombok.Data;

import java.util.List;

@Data
public class
KCQueryResult {
    private String agreementText;
    private String contractId;
    private KCKeyDTO key;
    private List<String> observers;
    private KCPayload payload;
    private List<String> signatories;
    private String templateId;
}

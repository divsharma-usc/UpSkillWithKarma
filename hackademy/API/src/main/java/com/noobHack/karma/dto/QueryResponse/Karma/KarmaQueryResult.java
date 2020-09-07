package com.noobHack.karma.dto.QueryResponse.Karma;

import com.noobHack.karma.Key.KarmaKey;
import lombok.Data;

import java.util.List;

@Data
public class KarmaQueryResult {
    private String agreementText;
    private String contractId;
    private KarmaKeyDTO key;
    private List<String> observers;
    private KarmaPayload payload;
    private List<String> signatories;
    private String templateId;
}

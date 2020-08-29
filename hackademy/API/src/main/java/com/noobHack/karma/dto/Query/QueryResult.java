package com.noobHack.karma.dto.Query;

import com.noobHack.karma.model.Karma.KarmaKey;
import com.noobHack.karma.model.Karma.KarmaPayload;
import lombok.Data;

import java.util.List;

@Data
public class QueryResult {
    private String agreementText;
    private String contractId;
    private KarmaKey key;
    private List<String> observers;
    private KarmaPayload payload;
    private List<String> signatories;
    private String templateId;
}

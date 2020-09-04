package com.noobHack.karma.dto.QueryResponse.Karma;

import com.noobHack.karma.Key.KarmaKey;
import com.noobHack.karma.model.Payload;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
public class KarmaPayload implements Payload {
    private String cId;
    private BigDecimal point;
    private List<String> signatories;
    private String courseProvider;
    private String psid;
    private KarmaKeyDTO id;
    private String operator;
    private String owner;
    private Instant creationTime;
}
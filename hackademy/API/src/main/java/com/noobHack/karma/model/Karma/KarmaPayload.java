package com.noobHack.karma.model.Karma;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
public class KarmaPayload {
    private String cId;
    private BigDecimal point;
    private List<String> signatories;
    private String courseProvider;
    private String psid;
    private KarmaKey id;
    private String operator;
    private String owner;
    private Instant creationTime;
}
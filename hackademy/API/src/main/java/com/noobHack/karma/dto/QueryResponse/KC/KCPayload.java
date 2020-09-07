package com.noobHack.karma.dto.QueryResponse.KC;

import com.noobHack.karma.Key.KCKey;
import com.noobHack.karma.model.Payload;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
public class KCPayload implements Payload {
    private String provider;
    private String taker;
    private String courseId;
    private BigDecimal amount;
    private String psid;
    private List<String> signatories;
    private KCKeyDTO id;
    private Instant creationTime;
    private Instant modificationTime;
    private String operator;
    private String status;
    private BigDecimal penality;
}

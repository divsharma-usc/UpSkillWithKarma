package hackademy.kc.kc;

import com.daml.ledger.javaapi.data.Bool;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Timestamp;
import com.daml.ledger.javaapi.data.Value;
import da.internal.template.Archive;
import hackademy.kc.lang.KCId;
import hackademy.kc.lang.Status;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class KC extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7", "HackAdemy.KC.KC", "KC");

  public final Status status;

  public final String cId;

  public final String psid;

  public final String operator;

  public final String taker;

  public final String provider;

  public final KCId id;

  public final BigDecimal amount;

  public final BigDecimal penality;

  public final Boolean isDone;

  public final Instant creationTime;

  public final Instant modificationTime;

  public KC(Status status, String cId, String psid, String operator, String taker, String provider,
      KCId id, BigDecimal amount, BigDecimal penality, Boolean isDone, Instant creationTime,
      Instant modificationTime) {
    this.status = status;
    this.cId = cId;
    this.psid = psid;
    this.operator = operator;
    this.taker = taker;
    this.provider = provider;
    this.id = id;
    this.amount = amount;
    this.penality = penality;
    this.isDone = isDone;
    this.creationTime = creationTime;
    this.modificationTime = modificationTime;
  }

  public CreateCommand create() {
    return new CreateCommand(KC.TEMPLATE_ID, this.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeySettle(KCId key, Settle arg) {
    return new ExerciseByKeyCommand(KC.TEMPLATE_ID, key.toValue(), "Settle", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeySettle(KCId key) {
    return KC.exerciseByKeySettle(key, new Settle());
  }

  public static ExerciseByKeyCommand exerciseByKeyCancel_KC(KCId key, Cancel_KC arg) {
    return new ExerciseByKeyCommand(KC.TEMPLATE_ID, key.toValue(), "Cancel_KC", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyCancel_KC(KCId key) {
    return KC.exerciseByKeyCancel_KC(key, new Cancel_KC());
  }

  public static ExerciseByKeyCommand exerciseByKeyArchive(KCId key, Archive arg) {
    return new ExerciseByKeyCommand(KC.TEMPLATE_ID, key.toValue(), "Archive", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyApprove_KC(KCId key, Approve_KC arg) {
    return new ExerciseByKeyCommand(KC.TEMPLATE_ID, key.toValue(), "Approve_KC", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyApprove_KC(KCId key) {
    return KC.exerciseByKeyApprove_KC(key, new Approve_KC());
  }

  public CreateAndExerciseCommand createAndExerciseSettle(Settle arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(KC.TEMPLATE_ID, this.toValue(), "Settle", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseSettle() {
    return createAndExerciseSettle(new Settle());
  }

  public CreateAndExerciseCommand createAndExerciseCancel_KC(Cancel_KC arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(KC.TEMPLATE_ID, this.toValue(), "Cancel_KC", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseCancel_KC() {
    return createAndExerciseCancel_KC(new Cancel_KC());
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Archive arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(KC.TEMPLATE_ID, this.toValue(), "Archive", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseApprove_KC(Approve_KC arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(KC.TEMPLATE_ID, this.toValue(), "Approve_KC", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseApprove_KC() {
    return createAndExerciseApprove_KC(new Approve_KC());
  }

  public static CreateCommand create(Status status, String cId, String psid, String operator,
      String taker, String provider, KCId id, BigDecimal amount, BigDecimal penality,
      Boolean isDone, Instant creationTime, Instant modificationTime) {
    return new KC(status, cId, psid, operator, taker, provider, id, amount, penality, isDone, creationTime, modificationTime).create();
  }

  public static KC fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 12) {
      throw new IllegalArgumentException("Expected 12 arguments, got " + numberOfFields);
    }
    Status status = Status.fromValue(fields$.get(0).getValue());
    String cId = fields$.get(1).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected cId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    String psid = fields$.get(2).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected psid to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    String operator = fields$.get(3).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected operator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String taker = fields$.get(4).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected taker to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String provider = fields$.get(5).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected provider to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    KCId id = KCId.fromValue(fields$.get(6).getValue());
    BigDecimal amount = fields$.get(7).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected amount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal penality = fields$.get(8).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected penality to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    Boolean isDone = fields$.get(9).getValue().asBool().orElseThrow(() -> new IllegalArgumentException("Expected isDone to be of type com.daml.ledger.javaapi.data.Bool")).getValue();
    Instant creationTime = fields$.get(10).getValue().asTimestamp().orElseThrow(() -> new IllegalArgumentException("Expected creationTime to be of type com.daml.ledger.javaapi.data.Timestamp")).getValue();
    Instant modificationTime = fields$.get(11).getValue().asTimestamp().orElseThrow(() -> new IllegalArgumentException("Expected modificationTime to be of type com.daml.ledger.javaapi.data.Timestamp")).getValue();
    return new hackademy.kc.kc.KC(status, cId, psid, operator, taker, provider, id, amount, penality, isDone, creationTime, modificationTime);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(12);
    fields.add(new Record.Field("status", this.status.toValue()));
    fields.add(new Record.Field("cId", new Text(this.cId)));
    fields.add(new Record.Field("psid", new Text(this.psid)));
    fields.add(new Record.Field("operator", new Party(this.operator)));
    fields.add(new Record.Field("taker", new Party(this.taker)));
    fields.add(new Record.Field("provider", new Party(this.provider)));
    fields.add(new Record.Field("id", this.id.toValue()));
    fields.add(new Record.Field("amount", new Numeric(this.amount)));
    fields.add(new Record.Field("penality", new Numeric(this.penality)));
    fields.add(new Record.Field("isDone", new Bool(this.isDone)));
    fields.add(new Record.Field("creationTime", Timestamp.fromInstant(this.creationTime)));
    fields.add(new Record.Field("modificationTime", Timestamp.fromInstant(this.modificationTime)));
    return new Record(fields);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof KC)) {
      return false;
    }
    KC other = (KC) object;
    return this.status.equals(other.status) && this.cId.equals(other.cId) && this.psid.equals(other.psid) && this.operator.equals(other.operator) && this.taker.equals(other.taker) && this.provider.equals(other.provider) && this.id.equals(other.id) && this.amount.equals(other.amount) && this.penality.equals(other.penality) && this.isDone.equals(other.isDone) && this.creationTime.equals(other.creationTime) && this.modificationTime.equals(other.modificationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.status, this.cId, this.psid, this.operator, this.taker, this.provider, this.id, this.amount, this.penality, this.isDone, this.creationTime, this.modificationTime);
  }

  @Override
  public String toString() {
    return String.format("hackademy.kc.kc.KC(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", this.status, this.cId, this.psid, this.operator, this.taker, this.provider, this.id, this.amount, this.penality, this.isDone, this.creationTime, this.modificationTime);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<KC> {
    public ContractId(String contractId) {
      super(contractId);
    }

    public ExerciseCommand exerciseSettle(Settle arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(KC.TEMPLATE_ID, this.contractId, "Settle", argValue);
    }

    public ExerciseCommand exerciseSettle() {
      return exerciseSettle(new Settle());
    }

    public ExerciseCommand exerciseCancel_KC(Cancel_KC arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(KC.TEMPLATE_ID, this.contractId, "Cancel_KC", argValue);
    }

    public ExerciseCommand exerciseCancel_KC() {
      return exerciseCancel_KC(new Cancel_KC());
    }

    public ExerciseCommand exerciseArchive(Archive arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(KC.TEMPLATE_ID, this.contractId, "Archive", argValue);
    }

    public ExerciseCommand exerciseApprove_KC(Approve_KC arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(KC.TEMPLATE_ID, this.contractId, "Approve_KC", argValue);
    }

    public ExerciseCommand exerciseApprove_KC() {
      return exerciseApprove_KC(new Approve_KC());
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final KC data;

    public final Optional<String> agreementText;

    public final Optional<KCId> key;

    public final Set<String> signatories;

    public final Set<String> observers;

    public Contract(ContractId id, KC data, Optional<String> agreementText, Optional<KCId> key,
        Set<String> signatories, Set<String> observers) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
      this.key = key;
      this.signatories = signatories;
      this.observers = observers;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText, Optional<KCId> key, Set<String> signatories,
        Set<String> observers) {
      ContractId id = new ContractId(contractId);
      KC data = KC.fromValue(record$);
      return new Contract(id, data, agreementText, key, signatories, observers);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      KC data = KC.fromValue(record$);
      return new Contract(id, data, Optional.empty(), Optional.empty(), Collections.emptySet(), Collections.emptySet());
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return fromIdAndRecord(event.getContractId(), event.getArguments(), event.getAgreementText(), event.getContractKey().map(e -> KCId.fromValue(e)), event.getSignatories(), event.getObservers());
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (object == null) {
        return false;
      }
      if (!(object instanceof Contract)) {
        return false;
      }
      Contract other = (Contract) object;
      return this.id.equals(other.id) && this.data.equals(other.data) && this.agreementText.equals(other.agreementText) && this.key.equals(other.key) && this.signatories.equals(other.signatories) && this.observers.equals(other.observers);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.data, this.agreementText, this.key, this.signatories, this.observers);
    }

    @Override
    public String toString() {
      return String.format("hackademy.kc.kc.KC.Contract(%s, %s, %s, %s, %s, %s)", this.id, this.data, this.agreementText, this.key, this.signatories, this.observers);
    }
  }
}

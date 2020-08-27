package hackademy.karma.karma;

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
import hackademy.karma.lang.KarmaId;
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

public final class Karma extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7", "HackAdemy.Karma.Karma", "Karma");

  public final String owner;

  public final String operator;

  public final String psid;

  public final BigDecimal point;

  public final String cId;

  public final Instant creationTime;

  public final KarmaId id;

  public Karma(String owner, String operator, String psid, BigDecimal point, String cId,
      Instant creationTime, KarmaId id) {
    this.owner = owner;
    this.operator = operator;
    this.psid = psid;
    this.point = point;
    this.cId = cId;
    this.creationTime = creationTime;
    this.id = id;
  }

  public CreateCommand create() {
    return new CreateCommand(Karma.TEMPLATE_ID, this.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyArchive(KarmaId key, Archive arg) {
    return new ExerciseByKeyCommand(Karma.TEMPLATE_ID, key.toValue(), "Archive", arg.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Archive arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Karma.TEMPLATE_ID, this.toValue(), "Archive", argValue);
  }

  public static CreateCommand create(String owner, String operator, String psid, BigDecimal point,
      String cId, Instant creationTime, KarmaId id) {
    return new Karma(owner, operator, psid, point, cId, creationTime, id).create();
  }

  public static Karma fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 7) {
      throw new IllegalArgumentException("Expected 7 arguments, got " + numberOfFields);
    }
    String owner = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected owner to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String operator = fields$.get(1).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected operator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String psid = fields$.get(2).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected psid to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    BigDecimal point = fields$.get(3).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected point to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    String cId = fields$.get(4).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected cId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    Instant creationTime = fields$.get(5).getValue().asTimestamp().orElseThrow(() -> new IllegalArgumentException("Expected creationTime to be of type com.daml.ledger.javaapi.data.Timestamp")).getValue();
    KarmaId id = KarmaId.fromValue(fields$.get(6).getValue());
    return new hackademy.karma.karma.Karma(owner, operator, psid, point, cId, creationTime, id);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(7);
    fields.add(new Record.Field("owner", new Party(this.owner)));
    fields.add(new Record.Field("operator", new Party(this.operator)));
    fields.add(new Record.Field("psid", new Text(this.psid)));
    fields.add(new Record.Field("point", new Numeric(this.point)));
    fields.add(new Record.Field("cId", new Text(this.cId)));
    fields.add(new Record.Field("creationTime", Timestamp.fromInstant(this.creationTime)));
    fields.add(new Record.Field("id", this.id.toValue()));
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
    if (!(object instanceof Karma)) {
      return false;
    }
    Karma other = (Karma) object;
    return this.owner.equals(other.owner) && this.operator.equals(other.operator) && this.psid.equals(other.psid) && this.point.equals(other.point) && this.cId.equals(other.cId) && this.creationTime.equals(other.creationTime) && this.id.equals(other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.owner, this.operator, this.psid, this.point, this.cId, this.creationTime, this.id);
  }

  @Override
  public String toString() {
    return String.format("hackademy.karma.karma.Karma(%s, %s, %s, %s, %s, %s, %s)", this.owner, this.operator, this.psid, this.point, this.cId, this.creationTime, this.id);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Karma> {
    public ContractId(String contractId) {
      super(contractId);
    }

    public ExerciseCommand exerciseArchive(Archive arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Karma.TEMPLATE_ID, this.contractId, "Archive", argValue);
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final Karma data;

    public final Optional<String> agreementText;

    public final Optional<KarmaId> key;

    public final Set<String> signatories;

    public final Set<String> observers;

    public Contract(ContractId id, Karma data, Optional<String> agreementText,
        Optional<KarmaId> key, Set<String> signatories, Set<String> observers) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
      this.key = key;
      this.signatories = signatories;
      this.observers = observers;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText, Optional<KarmaId> key, Set<String> signatories,
        Set<String> observers) {
      ContractId id = new ContractId(contractId);
      Karma data = Karma.fromValue(record$);
      return new Contract(id, data, agreementText, key, signatories, observers);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      Karma data = Karma.fromValue(record$);
      return new Contract(id, data, Optional.empty(), Optional.empty(), Collections.emptySet(), Collections.emptySet());
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return fromIdAndRecord(event.getContractId(), event.getArguments(), event.getAgreementText(), event.getContractKey().map(e -> KarmaId.fromValue(e)), event.getSignatories(), event.getObservers());
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
      return String.format("hackademy.karma.karma.Karma.Contract(%s, %s, %s, %s, %s, %s)", this.id, this.data, this.agreementText, this.key, this.signatories, this.observers);
    }
  }
}

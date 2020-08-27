package hackademy.roles.operatorrole;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Value;
import da.internal.template.Archive;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class OperatorRole extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7", "HackAdemy.Roles.OperatorRole", "OperatorRole");

  public final String operator;

  public OperatorRole(String operator) {
    this.operator = operator;
  }

  public CreateCommand create() {
    return new CreateCommand(OperatorRole.TEMPLATE_ID, this.toValue());
  }

  public CreateAndExerciseCommand createAndExerciseCreate_wallet(Create_wallet arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(OperatorRole.TEMPLATE_ID, this.toValue(), "Create_wallet", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseCreate_wallet(String owner, String psid,
      BigDecimal amount) {
    return createAndExerciseCreate_wallet(new Create_wallet(owner, psid, amount));
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Archive arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(OperatorRole.TEMPLATE_ID, this.toValue(), "Archive", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseInvite_CourseCreator(Invite_CourseCreator arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(OperatorRole.TEMPLATE_ID, this.toValue(), "Invite_CourseCreator", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseInvite_CourseCreator(String creator) {
    return createAndExerciseInvite_CourseCreator(new Invite_CourseCreator(creator));
  }

  public static CreateCommand create(String operator) {
    return new OperatorRole(operator).create();
  }

  public static OperatorRole fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String operator = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected operator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    return new hackademy.roles.operatorrole.OperatorRole(operator);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("operator", new Party(this.operator)));
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
    if (!(object instanceof OperatorRole)) {
      return false;
    }
    OperatorRole other = (OperatorRole) object;
    return this.operator.equals(other.operator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator);
  }

  @Override
  public String toString() {
    return String.format("hackademy.roles.operatorrole.OperatorRole(%s)", this.operator);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<OperatorRole> {
    public ContractId(String contractId) {
      super(contractId);
    }

    public ExerciseCommand exerciseCreate_wallet(Create_wallet arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(OperatorRole.TEMPLATE_ID, this.contractId, "Create_wallet", argValue);
    }

    public ExerciseCommand exerciseCreate_wallet(String owner, String psid, BigDecimal amount) {
      return exerciseCreate_wallet(new Create_wallet(owner, psid, amount));
    }

    public ExerciseCommand exerciseArchive(Archive arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(OperatorRole.TEMPLATE_ID, this.contractId, "Archive", argValue);
    }

    public ExerciseCommand exerciseInvite_CourseCreator(Invite_CourseCreator arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(OperatorRole.TEMPLATE_ID, this.contractId, "Invite_CourseCreator", argValue);
    }

    public ExerciseCommand exerciseInvite_CourseCreator(String creator) {
      return exerciseInvite_CourseCreator(new Invite_CourseCreator(creator));
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final OperatorRole data;

    public final Optional<String> agreementText;

    public final Set<String> signatories;

    public final Set<String> observers;

    public Contract(ContractId id, OperatorRole data, Optional<String> agreementText,
        Set<String> signatories, Set<String> observers) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
      this.signatories = signatories;
      this.observers = observers;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText, Set<String> signatories, Set<String> observers) {
      ContractId id = new ContractId(contractId);
      OperatorRole data = OperatorRole.fromValue(record$);
      return new Contract(id, data, agreementText, signatories, observers);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      OperatorRole data = OperatorRole.fromValue(record$);
      return new Contract(id, data, Optional.empty(), Collections.emptySet(), Collections.emptySet());
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return fromIdAndRecord(event.getContractId(), event.getArguments(), event.getAgreementText(), event.getSignatories(), event.getObservers());
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
      return this.id.equals(other.id) && this.data.equals(other.data) && this.agreementText.equals(other.agreementText) && this.signatories.equals(other.signatories) && this.observers.equals(other.observers);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.data, this.agreementText, this.signatories, this.observers);
    }

    @Override
    public String toString() {
      return String.format("hackademy.roles.operatorrole.OperatorRole.Contract(%s, %s, %s, %s, %s)", this.id, this.data, this.agreementText, this.signatories, this.observers);
    }
  }
}

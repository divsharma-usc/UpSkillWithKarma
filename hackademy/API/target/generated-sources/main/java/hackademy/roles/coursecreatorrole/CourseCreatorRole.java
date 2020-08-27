package hackademy.roles.coursecreatorrole;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Value;
import da.internal.template.Archive;
import hackademy.roles.lang.RoleId;
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

public final class CourseCreatorRole extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7", "HackAdemy.Roles.CourseCreatorRole", "CourseCreatorRole");

  public final String creator;

  public final String operator;

  public final RoleId id;

  public CourseCreatorRole(String creator, String operator, RoleId id) {
    this.creator = creator;
    this.operator = operator;
    this.id = id;
  }

  public CreateCommand create() {
    return new CreateCommand(CourseCreatorRole.TEMPLATE_ID, this.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyArchive(RoleId key, Archive arg) {
    return new ExerciseByKeyCommand(CourseCreatorRole.TEMPLATE_ID, key.toValue(), "Archive", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyCreate_Course(RoleId key, Create_Course arg) {
    return new ExerciseByKeyCommand(CourseCreatorRole.TEMPLATE_ID, key.toValue(), "Create_Course", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyCreate_Course(RoleId key, String cId,
      BigDecimal minimumTimeSpend, BigDecimal minimumPassingScore, BigDecimal amount,
      BigDecimal penality) {
    return CourseCreatorRole.exerciseByKeyCreate_Course(key, new Create_Course(cId, minimumTimeSpend, minimumPassingScore, amount, penality));
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Archive arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(CourseCreatorRole.TEMPLATE_ID, this.toValue(), "Archive", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseCreate_Course(Create_Course arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(CourseCreatorRole.TEMPLATE_ID, this.toValue(), "Create_Course", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseCreate_Course(String cId,
      BigDecimal minimumTimeSpend, BigDecimal minimumPassingScore, BigDecimal amount,
      BigDecimal penality) {
    return createAndExerciseCreate_Course(new Create_Course(cId, minimumTimeSpend, minimumPassingScore, amount, penality));
  }

  public static CreateCommand create(String creator, String operator, RoleId id) {
    return new CourseCreatorRole(creator, operator, id).create();
  }

  public static CourseCreatorRole fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 3) {
      throw new IllegalArgumentException("Expected 3 arguments, got " + numberOfFields);
    }
    String creator = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected creator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String operator = fields$.get(1).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected operator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    RoleId id = RoleId.fromValue(fields$.get(2).getValue());
    return new hackademy.roles.coursecreatorrole.CourseCreatorRole(creator, operator, id);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(3);
    fields.add(new Record.Field("creator", new Party(this.creator)));
    fields.add(new Record.Field("operator", new Party(this.operator)));
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
    if (!(object instanceof CourseCreatorRole)) {
      return false;
    }
    CourseCreatorRole other = (CourseCreatorRole) object;
    return this.creator.equals(other.creator) && this.operator.equals(other.operator) && this.id.equals(other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.operator, this.id);
  }

  @Override
  public String toString() {
    return String.format("hackademy.roles.coursecreatorrole.CourseCreatorRole(%s, %s, %s)", this.creator, this.operator, this.id);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<CourseCreatorRole> {
    public ContractId(String contractId) {
      super(contractId);
    }

    public ExerciseCommand exerciseArchive(Archive arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(CourseCreatorRole.TEMPLATE_ID, this.contractId, "Archive", argValue);
    }

    public ExerciseCommand exerciseCreate_Course(Create_Course arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(CourseCreatorRole.TEMPLATE_ID, this.contractId, "Create_Course", argValue);
    }

    public ExerciseCommand exerciseCreate_Course(String cId, BigDecimal minimumTimeSpend,
        BigDecimal minimumPassingScore, BigDecimal amount, BigDecimal penality) {
      return exerciseCreate_Course(new Create_Course(cId, minimumTimeSpend, minimumPassingScore, amount, penality));
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final CourseCreatorRole data;

    public final Optional<String> agreementText;

    public final Optional<RoleId> key;

    public final Set<String> signatories;

    public final Set<String> observers;

    public Contract(ContractId id, CourseCreatorRole data, Optional<String> agreementText,
        Optional<RoleId> key, Set<String> signatories, Set<String> observers) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
      this.key = key;
      this.signatories = signatories;
      this.observers = observers;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText, Optional<RoleId> key, Set<String> signatories,
        Set<String> observers) {
      ContractId id = new ContractId(contractId);
      CourseCreatorRole data = CourseCreatorRole.fromValue(record$);
      return new Contract(id, data, agreementText, key, signatories, observers);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      CourseCreatorRole data = CourseCreatorRole.fromValue(record$);
      return new Contract(id, data, Optional.empty(), Optional.empty(), Collections.emptySet(), Collections.emptySet());
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return fromIdAndRecord(event.getContractId(), event.getArguments(), event.getAgreementText(), event.getContractKey().map(e -> RoleId.fromValue(e)), event.getSignatories(), event.getObservers());
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
      return String.format("hackademy.roles.coursecreatorrole.CourseCreatorRole.Contract(%s, %s, %s, %s, %s, %s)", this.id, this.data, this.agreementText, this.key, this.signatories, this.observers);
    }
  }
}

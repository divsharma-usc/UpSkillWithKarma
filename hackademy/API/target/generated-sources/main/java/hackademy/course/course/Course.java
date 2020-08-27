package hackademy.course.course;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlCollectors;
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
import hackademy.course.lang.CourseId;
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

public final class Course extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7", "HackAdemy.Course.Course", "Course");

  public final String creator;

  public final String operator;

  public final String cId;

  public final BigDecimal minimumTimeSpend;

  public final BigDecimal minimumPassingScore;

  public final BigDecimal amount;

  public final BigDecimal penality;

  public final CourseId courseId;

  public final Instant creationTime;

  public final Instant modificationTime;

  public final List<String> observers;

  public Course(String creator, String operator, String cId, BigDecimal minimumTimeSpend,
      BigDecimal minimumPassingScore, BigDecimal amount, BigDecimal penality, CourseId courseId,
      Instant creationTime, Instant modificationTime, List<String> observers) {
    this.creator = creator;
    this.operator = operator;
    this.cId = cId;
    this.minimumTimeSpend = minimumTimeSpend;
    this.minimumPassingScore = minimumPassingScore;
    this.amount = amount;
    this.penality = penality;
    this.courseId = courseId;
    this.creationTime = creationTime;
    this.modificationTime = modificationTime;
    this.observers = observers;
  }

  public CreateCommand create() {
    return new CreateCommand(Course.TEMPLATE_ID, this.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyAdd_Observer(CourseId key, Add_Observer arg) {
    return new ExerciseByKeyCommand(Course.TEMPLATE_ID, key.toValue(), "Add_Observer", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyAdd_Observer(CourseId key, String newObserver) {
    return Course.exerciseByKeyAdd_Observer(key, new Add_Observer(newObserver));
  }

  public static ExerciseByKeyCommand exerciseByKeyArchive(CourseId key, Archive arg) {
    return new ExerciseByKeyCommand(Course.TEMPLATE_ID, key.toValue(), "Archive", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyEdit_Course(CourseId key, Edit_Course arg) {
    return new ExerciseByKeyCommand(Course.TEMPLATE_ID, key.toValue(), "Edit_Course", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyEdit_Course(CourseId key,
      BigDecimal newMinimumTimeSpend, BigDecimal newMinimumPassingScore, BigDecimal newAmount,
      BigDecimal newPenality) {
    return Course.exerciseByKeyEdit_Course(key, new Edit_Course(newMinimumTimeSpend, newMinimumPassingScore, newAmount, newPenality));
  }

  public CreateAndExerciseCommand createAndExerciseAdd_Observer(Add_Observer arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Course.TEMPLATE_ID, this.toValue(), "Add_Observer", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseAdd_Observer(String newObserver) {
    return createAndExerciseAdd_Observer(new Add_Observer(newObserver));
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Archive arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Course.TEMPLATE_ID, this.toValue(), "Archive", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseEdit_Course(Edit_Course arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(Course.TEMPLATE_ID, this.toValue(), "Edit_Course", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseEdit_Course(BigDecimal newMinimumTimeSpend,
      BigDecimal newMinimumPassingScore, BigDecimal newAmount, BigDecimal newPenality) {
    return createAndExerciseEdit_Course(new Edit_Course(newMinimumTimeSpend, newMinimumPassingScore, newAmount, newPenality));
  }

  public static CreateCommand create(String creator, String operator, String cId,
      BigDecimal minimumTimeSpend, BigDecimal minimumPassingScore, BigDecimal amount,
      BigDecimal penality, CourseId courseId, Instant creationTime, Instant modificationTime,
      List<String> observers) {
    return new Course(creator, operator, cId, minimumTimeSpend, minimumPassingScore, amount, penality, courseId, creationTime, modificationTime, observers).create();
  }

  public static Course fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 11) {
      throw new IllegalArgumentException("Expected 11 arguments, got " + numberOfFields);
    }
    String creator = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected creator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String operator = fields$.get(1).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected operator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String cId = fields$.get(2).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected cId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    BigDecimal minimumTimeSpend = fields$.get(3).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected minimumTimeSpend to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal minimumPassingScore = fields$.get(4).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected minimumPassingScore to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal amount = fields$.get(5).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected amount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal penality = fields$.get(6).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected penality to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    CourseId courseId = CourseId.fromValue(fields$.get(7).getValue());
    Instant creationTime = fields$.get(8).getValue().asTimestamp().orElseThrow(() -> new IllegalArgumentException("Expected creationTime to be of type com.daml.ledger.javaapi.data.Timestamp")).getValue();
    Instant modificationTime = fields$.get(9).getValue().asTimestamp().orElseThrow(() -> new IllegalArgumentException("Expected modificationTime to be of type com.daml.ledger.javaapi.data.Timestamp")).getValue();
    List<String> observers = fields$.get(10).getValue().asList()
            .map(v$0 -> v$0.toList(v$1 ->
                v$1.asParty().orElseThrow(() -> new IllegalArgumentException("Expected v$1 to be of type com.daml.ledger.javaapi.data.Party")).getValue()
            ))
            .orElseThrow(() -> new IllegalArgumentException("Expected observers to be of type com.daml.ledger.javaapi.data.DamlList"))
        ;
    return new hackademy.course.course.Course(creator, operator, cId, minimumTimeSpend, minimumPassingScore, amount, penality, courseId, creationTime, modificationTime, observers);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(11);
    fields.add(new Record.Field("creator", new Party(this.creator)));
    fields.add(new Record.Field("operator", new Party(this.operator)));
    fields.add(new Record.Field("cId", new Text(this.cId)));
    fields.add(new Record.Field("minimumTimeSpend", new Numeric(this.minimumTimeSpend)));
    fields.add(new Record.Field("minimumPassingScore", new Numeric(this.minimumPassingScore)));
    fields.add(new Record.Field("amount", new Numeric(this.amount)));
    fields.add(new Record.Field("penality", new Numeric(this.penality)));
    fields.add(new Record.Field("courseId", this.courseId.toValue()));
    fields.add(new Record.Field("creationTime", Timestamp.fromInstant(this.creationTime)));
    fields.add(new Record.Field("modificationTime", Timestamp.fromInstant(this.modificationTime)));
    fields.add(new Record.Field("observers", this.observers.stream().collect(DamlCollectors.toDamlList(v$0 -> new Party(v$0)))));
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
    if (!(object instanceof Course)) {
      return false;
    }
    Course other = (Course) object;
    return this.creator.equals(other.creator) && this.operator.equals(other.operator) && this.cId.equals(other.cId) && this.minimumTimeSpend.equals(other.minimumTimeSpend) && this.minimumPassingScore.equals(other.minimumPassingScore) && this.amount.equals(other.amount) && this.penality.equals(other.penality) && this.courseId.equals(other.courseId) && this.creationTime.equals(other.creationTime) && this.modificationTime.equals(other.modificationTime) && this.observers.equals(other.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.operator, this.cId, this.minimumTimeSpend, this.minimumPassingScore, this.amount, this.penality, this.courseId, this.creationTime, this.modificationTime, this.observers);
  }

  @Override
  public String toString() {
    return String.format("hackademy.course.course.Course(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", this.creator, this.operator, this.cId, this.minimumTimeSpend, this.minimumPassingScore, this.amount, this.penality, this.courseId, this.creationTime, this.modificationTime, this.observers);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Course> {
    public ContractId(String contractId) {
      super(contractId);
    }

    public ExerciseCommand exerciseAdd_Observer(Add_Observer arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Course.TEMPLATE_ID, this.contractId, "Add_Observer", argValue);
    }

    public ExerciseCommand exerciseAdd_Observer(String newObserver) {
      return exerciseAdd_Observer(new Add_Observer(newObserver));
    }

    public ExerciseCommand exerciseArchive(Archive arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Course.TEMPLATE_ID, this.contractId, "Archive", argValue);
    }

    public ExerciseCommand exerciseEdit_Course(Edit_Course arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(Course.TEMPLATE_ID, this.contractId, "Edit_Course", argValue);
    }

    public ExerciseCommand exerciseEdit_Course(BigDecimal newMinimumTimeSpend,
        BigDecimal newMinimumPassingScore, BigDecimal newAmount, BigDecimal newPenality) {
      return exerciseEdit_Course(new Edit_Course(newMinimumTimeSpend, newMinimumPassingScore, newAmount, newPenality));
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final Course data;

    public final Optional<String> agreementText;

    public final Optional<CourseId> key;

    public final Set<String> signatories;

    public final Set<String> observers;

    public Contract(ContractId id, Course data, Optional<String> agreementText,
        Optional<CourseId> key, Set<String> signatories, Set<String> observers) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
      this.key = key;
      this.signatories = signatories;
      this.observers = observers;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText, Optional<CourseId> key, Set<String> signatories,
        Set<String> observers) {
      ContractId id = new ContractId(contractId);
      Course data = Course.fromValue(record$);
      return new Contract(id, data, agreementText, key, signatories, observers);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      Course data = Course.fromValue(record$);
      return new Contract(id, data, Optional.empty(), Optional.empty(), Collections.emptySet(), Collections.emptySet());
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return fromIdAndRecord(event.getContractId(), event.getArguments(), event.getAgreementText(), event.getContractKey().map(e -> CourseId.fromValue(e)), event.getSignatories(), event.getObservers());
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
      return String.format("hackademy.course.course.Course.Contract(%s, %s, %s, %s, %s, %s)", this.id, this.data, this.agreementText, this.key, this.signatories, this.observers);
    }
  }
}

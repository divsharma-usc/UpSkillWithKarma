package hackademy.roles.coursecreatorrole;

import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Create_Course {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final String cId;

  public final BigDecimal minimumTimeSpend;

  public final BigDecimal minimumPassingScore;

  public final BigDecimal amount;

  public final BigDecimal penality;

  public Create_Course(String cId, BigDecimal minimumTimeSpend, BigDecimal minimumPassingScore,
      BigDecimal amount, BigDecimal penality) {
    this.cId = cId;
    this.minimumTimeSpend = minimumTimeSpend;
    this.minimumPassingScore = minimumPassingScore;
    this.amount = amount;
    this.penality = penality;
  }

  public static Create_Course fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 5) {
      throw new IllegalArgumentException("Expected 5 arguments, got " + numberOfFields);
    }
    String cId = fields$.get(0).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected cId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    BigDecimal minimumTimeSpend = fields$.get(1).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected minimumTimeSpend to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal minimumPassingScore = fields$.get(2).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected minimumPassingScore to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal amount = fields$.get(3).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected amount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal penality = fields$.get(4).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected penality to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    return new hackademy.roles.coursecreatorrole.Create_Course(cId, minimumTimeSpend, minimumPassingScore, amount, penality);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(5);
    fields.add(new Record.Field("cId", new Text(this.cId)));
    fields.add(new Record.Field("minimumTimeSpend", new Numeric(this.minimumTimeSpend)));
    fields.add(new Record.Field("minimumPassingScore", new Numeric(this.minimumPassingScore)));
    fields.add(new Record.Field("amount", new Numeric(this.amount)));
    fields.add(new Record.Field("penality", new Numeric(this.penality)));
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
    if (!(object instanceof Create_Course)) {
      return false;
    }
    Create_Course other = (Create_Course) object;
    return this.cId.equals(other.cId) && this.minimumTimeSpend.equals(other.minimumTimeSpend) && this.minimumPassingScore.equals(other.minimumPassingScore) && this.amount.equals(other.amount) && this.penality.equals(other.penality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.cId, this.minimumTimeSpend, this.minimumPassingScore, this.amount, this.penality);
  }

  @Override
  public String toString() {
    return String.format("hackademy.roles.coursecreatorrole.Create_Course(%s, %s, %s, %s, %s)", this.cId, this.minimumTimeSpend, this.minimumPassingScore, this.amount, this.penality);
  }
}

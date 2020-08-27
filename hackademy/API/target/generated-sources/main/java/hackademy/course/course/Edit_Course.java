package hackademy.course.course;

import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Edit_Course {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final BigDecimal newMinimumTimeSpend;

  public final BigDecimal newMinimumPassingScore;

  public final BigDecimal newAmount;

  public final BigDecimal newPenality;

  public Edit_Course(BigDecimal newMinimumTimeSpend, BigDecimal newMinimumPassingScore,
      BigDecimal newAmount, BigDecimal newPenality) {
    this.newMinimumTimeSpend = newMinimumTimeSpend;
    this.newMinimumPassingScore = newMinimumPassingScore;
    this.newAmount = newAmount;
    this.newPenality = newPenality;
  }

  public static Edit_Course fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 4) {
      throw new IllegalArgumentException("Expected 4 arguments, got " + numberOfFields);
    }
    BigDecimal newMinimumTimeSpend = fields$.get(0).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected newMinimumTimeSpend to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal newMinimumPassingScore = fields$.get(1).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected newMinimumPassingScore to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal newAmount = fields$.get(2).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected newAmount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    BigDecimal newPenality = fields$.get(3).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected newPenality to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    return new hackademy.course.course.Edit_Course(newMinimumTimeSpend, newMinimumPassingScore, newAmount, newPenality);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(4);
    fields.add(new Record.Field("newMinimumTimeSpend", new Numeric(this.newMinimumTimeSpend)));
    fields.add(new Record.Field("newMinimumPassingScore", new Numeric(this.newMinimumPassingScore)));
    fields.add(new Record.Field("newAmount", new Numeric(this.newAmount)));
    fields.add(new Record.Field("newPenality", new Numeric(this.newPenality)));
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
    if (!(object instanceof Edit_Course)) {
      return false;
    }
    Edit_Course other = (Edit_Course) object;
    return this.newMinimumTimeSpend.equals(other.newMinimumTimeSpend) && this.newMinimumPassingScore.equals(other.newMinimumPassingScore) && this.newAmount.equals(other.newAmount) && this.newPenality.equals(other.newPenality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newMinimumTimeSpend, this.newMinimumPassingScore, this.newAmount, this.newPenality);
  }

  @Override
  public String toString() {
    return String.format("hackademy.course.course.Edit_Course(%s, %s, %s, %s)", this.newMinimumTimeSpend, this.newMinimumPassingScore, this.newAmount, this.newPenality);
  }
}

package hackademy.course.course;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Add_Observer {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final String newObserver;

  public Add_Observer(String newObserver) {
    this.newObserver = newObserver;
  }

  public static Add_Observer fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String newObserver = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected newObserver to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    return new hackademy.course.course.Add_Observer(newObserver);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("newObserver", new Party(this.newObserver)));
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
    if (!(object instanceof Add_Observer)) {
      return false;
    }
    Add_Observer other = (Add_Observer) object;
    return this.newObserver.equals(other.newObserver);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newObserver);
  }

  @Override
  public String toString() {
    return String.format("hackademy.course.course.Add_Observer(%s)", this.newObserver);
  }
}

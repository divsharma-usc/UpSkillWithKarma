package hackademy.roles.operatorrole;

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

public class Invite_CourseCreator {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final String creator;

  public Invite_CourseCreator(String creator) {
    this.creator = creator;
  }

  public static Invite_CourseCreator fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String creator = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected creator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    return new hackademy.roles.operatorrole.Invite_CourseCreator(creator);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("creator", new Party(this.creator)));
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
    if (!(object instanceof Invite_CourseCreator)) {
      return false;
    }
    Invite_CourseCreator other = (Invite_CourseCreator) object;
    return this.creator.equals(other.creator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator);
  }

  @Override
  public String toString() {
    return String.format("hackademy.roles.operatorrole.Invite_CourseCreator(%s)", this.creator);
  }
}

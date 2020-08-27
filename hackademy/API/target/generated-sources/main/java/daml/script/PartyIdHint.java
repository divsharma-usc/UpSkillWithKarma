package daml.script;

import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartyIdHint {
  public static final String _packageId = "afc00281e795979ba84cedbe3ece16cab3accb50b0d0b331168e414bf4dd9bbb";

  public final String partyIdHint;

  public PartyIdHint(String partyIdHint) {
    this.partyIdHint = partyIdHint;
  }

  public static PartyIdHint fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String partyIdHint = fields$.get(0).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected partyIdHint to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    return new daml.script.PartyIdHint(partyIdHint);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("partyIdHint", new Text(this.partyIdHint)));
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
    if (!(object instanceof PartyIdHint)) {
      return false;
    }
    PartyIdHint other = (PartyIdHint) object;
    return this.partyIdHint.equals(other.partyIdHint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.partyIdHint);
  }

  @Override
  public String toString() {
    return String.format("daml.script.PartyIdHint(%s)", this.partyIdHint);
  }
}

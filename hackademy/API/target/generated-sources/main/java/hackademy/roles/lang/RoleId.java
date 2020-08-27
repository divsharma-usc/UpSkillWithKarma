package hackademy.roles.lang;

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

public class RoleId {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final String party;

  public final String operator;

  public RoleId(String party, String operator) {
    this.party = party;
    this.operator = operator;
  }

  public static RoleId fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 2) {
      throw new IllegalArgumentException("Expected 2 arguments, got " + numberOfFields);
    }
    String party = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected party to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String operator = fields$.get(1).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected operator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    return new hackademy.roles.lang.RoleId(party, operator);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(2);
    fields.add(new Record.Field("party", new Party(this.party)));
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
    if (!(object instanceof RoleId)) {
      return false;
    }
    RoleId other = (RoleId) object;
    return this.party.equals(other.party) && this.operator.equals(other.operator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.party, this.operator);
  }

  @Override
  public String toString() {
    return String.format("hackademy.roles.lang.RoleId(%s, %s)", this.party, this.operator);
  }
}

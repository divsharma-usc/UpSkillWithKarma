package hackademy.karma.lang;

import com.daml.ledger.javaapi.data.Party;
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

public class KarmaId {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final String cId;

  public final String psid;

  public final String operator;

  public KarmaId(String cId, String psid, String operator) {
    this.cId = cId;
    this.psid = psid;
    this.operator = operator;
  }

  public static KarmaId fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 3) {
      throw new IllegalArgumentException("Expected 3 arguments, got " + numberOfFields);
    }
    String cId = fields$.get(0).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected cId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    String psid = fields$.get(1).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected psid to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    String operator = fields$.get(2).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected operator to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    return new hackademy.karma.lang.KarmaId(cId, psid, operator);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(3);
    fields.add(new Record.Field("cId", new Text(this.cId)));
    fields.add(new Record.Field("psid", new Text(this.psid)));
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
    if (!(object instanceof KarmaId)) {
      return false;
    }
    KarmaId other = (KarmaId) object;
    return this.cId.equals(other.cId) && this.psid.equals(other.psid) && this.operator.equals(other.operator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.cId, this.psid, this.operator);
  }

  @Override
  public String toString() {
    return String.format("hackademy.karma.lang.KarmaId(%s, %s, %s)", this.cId, this.psid, this.operator);
  }
}

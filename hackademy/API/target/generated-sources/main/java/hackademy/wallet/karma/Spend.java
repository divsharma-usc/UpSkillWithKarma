package hackademy.wallet.karma;

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

public class Spend {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final String cId;

  public Spend(String cId) {
    this.cId = cId;
  }

  public static Spend fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String cId = fields$.get(0).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected cId to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    return new hackademy.wallet.karma.Spend(cId);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("cId", new Text(this.cId)));
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
    if (!(object instanceof Spend)) {
      return false;
    }
    Spend other = (Spend) object;
    return this.cId.equals(other.cId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.cId);
  }

  @Override
  public String toString() {
    return String.format("hackademy.wallet.karma.Spend(%s)", this.cId);
  }
}

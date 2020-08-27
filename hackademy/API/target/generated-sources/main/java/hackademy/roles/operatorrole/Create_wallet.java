package hackademy.roles.operatorrole;

import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Party;
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

public class Create_wallet {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final String owner;

  public final String psid;

  public final BigDecimal amount;

  public Create_wallet(String owner, String psid, BigDecimal amount) {
    this.owner = owner;
    this.psid = psid;
    this.amount = amount;
  }

  public static Create_wallet fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 3) {
      throw new IllegalArgumentException("Expected 3 arguments, got " + numberOfFields);
    }
    String owner = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected owner to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String psid = fields$.get(1).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected psid to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    BigDecimal amount = fields$.get(2).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected amount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    return new hackademy.roles.operatorrole.Create_wallet(owner, psid, amount);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(3);
    fields.add(new Record.Field("owner", new Party(this.owner)));
    fields.add(new Record.Field("psid", new Text(this.psid)));
    fields.add(new Record.Field("amount", new Numeric(this.amount)));
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
    if (!(object instanceof Create_wallet)) {
      return false;
    }
    Create_wallet other = (Create_wallet) object;
    return this.owner.equals(other.owner) && this.psid.equals(other.psid) && this.amount.equals(other.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.owner, this.psid, this.amount);
  }

  @Override
  public String toString() {
    return String.format("hackademy.roles.operatorrole.Create_wallet(%s, %s, %s)", this.owner, this.psid, this.amount);
  }
}

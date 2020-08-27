package hackademy.wallet.karma;

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

public class Add_Amount {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final BigDecimal addAmount;

  public Add_Amount(BigDecimal addAmount) {
    this.addAmount = addAmount;
  }

  public static Add_Amount fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    BigDecimal addAmount = fields$.get(0).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected addAmount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    return new hackademy.wallet.karma.Add_Amount(addAmount);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("addAmount", new Numeric(this.addAmount)));
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
    if (!(object instanceof Add_Amount)) {
      return false;
    }
    Add_Amount other = (Add_Amount) object;
    return this.addAmount.equals(other.addAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.addAmount);
  }

  @Override
  public String toString() {
    return String.format("hackademy.wallet.karma.Add_Amount(%s)", this.addAmount);
  }
}

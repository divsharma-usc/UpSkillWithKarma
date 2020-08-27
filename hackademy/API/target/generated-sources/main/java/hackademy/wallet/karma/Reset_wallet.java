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

public class Reset_wallet {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final BigDecimal resetAmount;

  public Reset_wallet(BigDecimal resetAmount) {
    this.resetAmount = resetAmount;
  }

  public static Reset_wallet fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    BigDecimal resetAmount = fields$.get(0).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected resetAmount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    return new hackademy.wallet.karma.Reset_wallet(resetAmount);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("resetAmount", new Numeric(this.resetAmount)));
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
    if (!(object instanceof Reset_wallet)) {
      return false;
    }
    Reset_wallet other = (Reset_wallet) object;
    return this.resetAmount.equals(other.resetAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.resetAmount);
  }

  @Override
  public String toString() {
    return String.format("hackademy.wallet.karma.Reset_wallet(%s)", this.resetAmount);
  }
}

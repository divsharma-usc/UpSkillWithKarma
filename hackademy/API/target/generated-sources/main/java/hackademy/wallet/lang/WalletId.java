package hackademy.wallet.lang;

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

public class WalletId {
  public static final String _packageId = "0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7";

  public final String provider;

  public final String psid;

  public final WalletType walletType;

  public WalletId(String provider, String psid, WalletType walletType) {
    this.provider = provider;
    this.psid = psid;
    this.walletType = walletType;
  }

  public static WalletId fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 3) {
      throw new IllegalArgumentException("Expected 3 arguments, got " + numberOfFields);
    }
    String provider = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected provider to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String psid = fields$.get(1).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected psid to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    WalletType walletType = WalletType.fromValue(fields$.get(2).getValue());
    return new hackademy.wallet.lang.WalletId(provider, psid, walletType);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(3);
    fields.add(new Record.Field("provider", new Party(this.provider)));
    fields.add(new Record.Field("psid", new Text(this.psid)));
    fields.add(new Record.Field("walletType", this.walletType.toValue()));
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
    if (!(object instanceof WalletId)) {
      return false;
    }
    WalletId other = (WalletId) object;
    return this.provider.equals(other.provider) && this.psid.equals(other.psid) && this.walletType.equals(other.walletType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.provider, this.psid, this.walletType);
  }

  @Override
  public String toString() {
    return String.format("hackademy.wallet.lang.WalletId(%s, %s, %s)", this.provider, this.psid, this.walletType);
  }
}

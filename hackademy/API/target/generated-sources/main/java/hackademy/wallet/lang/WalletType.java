package hackademy.wallet.lang;

import com.daml.ledger.javaapi.data.DamlEnum;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum WalletType {
  DEAD,

  LIVE;

  private static final DamlEnum[] __values$ = {new DamlEnum("Dead"), new DamlEnum("Live")};

  private static final Map<String, WalletType> __enums$ = WalletType.__buildEnumsMap$();

  private static final Map<String, WalletType> __buildEnumsMap$() {
    Map<String, WalletType> m = new HashMap<String, WalletType>();
    m.put("Dead", DEAD);
    m.put("Live", LIVE);
    return m;
  }

  public static final WalletType fromValue(Value value$) {
    String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum WalletType")).getConstructor();
    if (!WalletType.__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with WalletType constructor, found " + constructor$);
    return (WalletType) WalletType.__enums$.get(constructor$);
  }

  public final DamlEnum toValue() {
    return WalletType.__values$[ordinal()];
  }
}

package hackademy.kc.lang;

import com.daml.ledger.javaapi.data.DamlEnum;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public enum Status {
  SETTLED,

  UNSETTLED,

  CANCEL;

  private static final DamlEnum[] __values$ = {new DamlEnum("Settled"), new DamlEnum("UnSettled"), new DamlEnum("Cancel")};

  private static final Map<String, Status> __enums$ = Status.__buildEnumsMap$();

  private static final Map<String, Status> __buildEnumsMap$() {
    Map<String, Status> m = new HashMap<String, Status>();
    m.put("Settled", SETTLED);
    m.put("UnSettled", UNSETTLED);
    m.put("Cancel", CANCEL);
    return m;
  }

  public static final Status fromValue(Value value$) {
    String constructor$ = value$.asEnum().orElseThrow(() -> new IllegalArgumentException("Expected DamlEnum to build an instance of the Enum Status")).getConstructor();
    if (!Status.__enums$.containsKey(constructor$)) throw new IllegalArgumentException("Expected a DamlEnum with Status constructor, found " + constructor$);
    return (Status) Status.__enums$.get(constructor$);
  }

  public final DamlEnum toValue() {
    return Status.__values$[ordinal()];
  }
}

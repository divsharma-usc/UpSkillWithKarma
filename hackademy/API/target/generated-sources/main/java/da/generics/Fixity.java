package da.generics;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.String;

public abstract class Fixity {
  public static final String _packageId = "2e496c511afa01bee46a954470a0d8433a28dcce7afa1cfaaabb92604a64c542";

  public Fixity() {
  }

  public abstract Value toValue();

  public static Fixity fromValue(Value value$) {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected Variant to build an instance of the Variant da.generics.Fixity"));
    if ("Prefix".equals(variant$.getConstructor())) {
      return da.generics.fixity.Prefix.fromValue(variant$);
    }
    if ("Infix".equals(variant$.getConstructor())) {
      return da.generics.fixity.Infix.fromValue(variant$);
    }
    throw new IllegalArgumentException("Found unknown constructor variant$.getConstructor() for variant da.generics.Fixity, expected one of [Prefix, Infix]");
  }
}

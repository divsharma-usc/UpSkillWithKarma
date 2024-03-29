package da.types.either;

import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import da.types.Either;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.function.Function;

public class Right<a, b> extends Either<a, b> {
  public static final String _packageId = "40f452260bef3f29dede136108fc08a88d5a5250310281067087da6f0baddff7";

  public final b bValue;

  public Right(b bValue) {
    this.bValue = bValue;
  }

  public Variant toValue(Function<b, Value> toValueb) {
    return new Variant("Right", toValueb.apply(this.bValue));
  }

  public static <a, b> Right<a, b> fromValue(Value value$, Function<Value, b> fromValueb) throws
      IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Right".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Right. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    b body = fromValueb.apply(variantValue$);
    return new Right<a, b>(body);
  }

  public Variant toValue(Function<a, Value> toValuea, Function<b, Value> toValueb) {
    return new Variant("Right", toValueb.apply(this.bValue));
  }

  public static <a, b> Right<a, b> fromValue(Value value$, Function<Value, a> fromValuea,
      Function<Value, b> fromValueb) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Right".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Right. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    b body = fromValueb.apply(variantValue$);
    return new Right<a, b>(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Right<?, ?>)) {
      return false;
    }
    Right<?, ?> other = (Right<?, ?>) object;
    return this.bValue.equals(other.bValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.bValue);
  }

  @Override
  public String toString() {
    return String.format("Right(%s)", this.bValue);
  }
}

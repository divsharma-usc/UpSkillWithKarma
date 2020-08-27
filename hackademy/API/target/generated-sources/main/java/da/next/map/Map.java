package da.next.map;

import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Map<k_a9x0, v_a9x1> {
  public static final String _packageId = "2e496c511afa01bee46a954470a0d8433a28dcce7afa1cfaaabb92604a64c542";

  public final java.util.Map<String, v_a9x1> textMap;

  public Map(java.util.Map<String, v_a9x1> textMap) {
    this.textMap = textMap;
  }

  public static <k_a9x0, v_a9x1> Map<k_a9x0, v_a9x1> fromValue(Value value$,
      Function<Value, v_a9x1> fromValuev_a9x1) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    java.util.Map<String, v_a9x1> textMap = fields$.get(0).getValue().asTextMap()
            .map(v$0 -> v$0.toMap(v$1 ->
                fromValuev_a9x1.apply(v$1)
            ))
            .orElseThrow(() -> new IllegalArgumentException("Expected textMap to be of type com.daml.ledger.javaapi.data.DamlTextMap"))
                  ;
    return new da.next.map.Map<k_a9x0, v_a9x1>(textMap);
  }

  public Record toValue(Function<v_a9x1, Value> toValuev_a9x1) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("textMap", this.textMap.entrySet().stream().collect(DamlCollectors.toDamlTextMap(java.util.Map.Entry::getKey, v$0 -> toValuev_a9x1.apply(v$0.getValue()))) ));
    return new Record(fields);
  }

  public static <k_a9x0, v_a9x1> Map<k_a9x0, v_a9x1> fromValue(Value value$,
      Function<Value, k_a9x0> fromValuek_a9x0, Function<Value, v_a9x1> fromValuev_a9x1) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    java.util.Map<String, v_a9x1> textMap = fields$.get(0).getValue().asTextMap()
            .map(v$0 -> v$0.toMap(v$1 ->
                fromValuev_a9x1.apply(v$1)
            ))
            .orElseThrow(() -> new IllegalArgumentException("Expected textMap to be of type com.daml.ledger.javaapi.data.DamlTextMap"))
                  ;
    return new da.next.map.Map<k_a9x0, v_a9x1>(textMap);
  }

  public Record toValue(Function<k_a9x0, Value> toValuek_a9x0,
      Function<v_a9x1, Value> toValuev_a9x1) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("textMap", this.textMap.entrySet().stream().collect(DamlCollectors.toDamlTextMap(java.util.Map.Entry::getKey, v$0 -> toValuev_a9x1.apply(v$0.getValue()))) ));
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
    if (!(object instanceof Map<?, ?>)) {
      return false;
    }
    Map<?, ?> other = (Map<?, ?>) object;
    return this.textMap.equals(other.textMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.textMap);
  }

  @Override
  public String toString() {
    return String.format("da.next.map.Map(%s)", this.textMap);
  }
}

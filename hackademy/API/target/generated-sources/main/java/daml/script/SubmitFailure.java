package daml.script;

import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubmitFailure {
  public static final String _packageId = "afc00281e795979ba84cedbe3ece16cab3accb50b0d0b331168e414bf4dd9bbb";

  public final Long status;

  public final String description;

  public SubmitFailure(Long status, String description) {
    this.status = status;
    this.description = description;
  }

  public static SubmitFailure fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 2) {
      throw new IllegalArgumentException("Expected 2 arguments, got " + numberOfFields);
    }
    Long status = fields$.get(0).getValue().asInt64().orElseThrow(() -> new IllegalArgumentException("Expected status to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    String description = fields$.get(1).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected description to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    return new daml.script.SubmitFailure(status, description);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(2);
    fields.add(new Record.Field("status", new Int64(this.status)));
    fields.add(new Record.Field("description", new Text(this.description)));
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
    if (!(object instanceof SubmitFailure)) {
      return false;
    }
    SubmitFailure other = (SubmitFailure) object;
    return this.status.equals(other.status) && this.description.equals(other.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.status, this.description);
  }

  @Override
  public String toString() {
    return String.format("daml.script.SubmitFailure(%s, %s)", this.status, this.description);
  }
}

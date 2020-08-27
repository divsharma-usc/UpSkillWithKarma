package daml.script;

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

public class ParticipantName {
  public static final String _packageId = "afc00281e795979ba84cedbe3ece16cab3accb50b0d0b331168e414bf4dd9bbb";

  public final String participantName;

  public ParticipantName(String participantName) {
    this.participantName = participantName;
  }

  public static ParticipantName fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String participantName = fields$.get(0).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected participantName to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    return new daml.script.ParticipantName(participantName);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("participantName", new Text(this.participantName)));
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
    if (!(object instanceof ParticipantName)) {
      return false;
    }
    ParticipantName other = (ParticipantName) object;
    return this.participantName.equals(other.participantName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.participantName);
  }

  @Override
  public String toString() {
    return String.format("daml.script.ParticipantName(%s)", this.participantName);
  }
}

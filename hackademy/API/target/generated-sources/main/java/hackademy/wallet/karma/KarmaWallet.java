package hackademy.wallet.karma;

import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Timestamp;
import com.daml.ledger.javaapi.data.Value;
import da.internal.template.Archive;
import hackademy.wallet.lang.WalletId;
import hackademy.wallet.lang.WalletType;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class KarmaWallet extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("0ca6a54f53e2f5dbfa5a0b6a194738a005c5f5bdaa1821dc95f3add0df3594e7", "HackAdemy.Wallet.Karma", "KarmaWallet");

  public final String owner;

  public final WalletId id;

  public final String provider;

  public final String psid;

  public final WalletType walletType;

  public final BigDecimal amount;

  public final Instant creationTime;

  public final Instant modificationTime;

  public KarmaWallet(String owner, WalletId id, String provider, String psid, WalletType walletType,
      BigDecimal amount, Instant creationTime, Instant modificationTime) {
    this.owner = owner;
    this.id = id;
    this.provider = provider;
    this.psid = psid;
    this.walletType = walletType;
    this.amount = amount;
    this.creationTime = creationTime;
    this.modificationTime = modificationTime;
  }

  public CreateCommand create() {
    return new CreateCommand(KarmaWallet.TEMPLATE_ID, this.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyReset_wallet(WalletId key, Reset_wallet arg) {
    return new ExerciseByKeyCommand(KarmaWallet.TEMPLATE_ID, key.toValue(), "Reset_wallet", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyReset_wallet(WalletId key,
      BigDecimal resetAmount) {
    return KarmaWallet.exerciseByKeyReset_wallet(key, new Reset_wallet(resetAmount));
  }

  public static ExerciseByKeyCommand exerciseByKeyAdd_Amount(WalletId key, Add_Amount arg) {
    return new ExerciseByKeyCommand(KarmaWallet.TEMPLATE_ID, key.toValue(), "Add_Amount", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeyAdd_Amount(WalletId key, BigDecimal addAmount) {
    return KarmaWallet.exerciseByKeyAdd_Amount(key, new Add_Amount(addAmount));
  }

  public static ExerciseByKeyCommand exerciseByKeyArchive(WalletId key, Archive arg) {
    return new ExerciseByKeyCommand(KarmaWallet.TEMPLATE_ID, key.toValue(), "Archive", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeySpend(WalletId key, Spend arg) {
    return new ExerciseByKeyCommand(KarmaWallet.TEMPLATE_ID, key.toValue(), "Spend", arg.toValue());
  }

  public static ExerciseByKeyCommand exerciseByKeySpend(WalletId key, String cId) {
    return KarmaWallet.exerciseByKeySpend(key, new Spend(cId));
  }

  public CreateAndExerciseCommand createAndExerciseReset_wallet(Reset_wallet arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(KarmaWallet.TEMPLATE_ID, this.toValue(), "Reset_wallet", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseReset_wallet(BigDecimal resetAmount) {
    return createAndExerciseReset_wallet(new Reset_wallet(resetAmount));
  }

  public CreateAndExerciseCommand createAndExerciseAdd_Amount(Add_Amount arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(KarmaWallet.TEMPLATE_ID, this.toValue(), "Add_Amount", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseAdd_Amount(BigDecimal addAmount) {
    return createAndExerciseAdd_Amount(new Add_Amount(addAmount));
  }

  public CreateAndExerciseCommand createAndExerciseArchive(Archive arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(KarmaWallet.TEMPLATE_ID, this.toValue(), "Archive", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseSpend(Spend arg) {
    Value argValue = arg.toValue();
    return new CreateAndExerciseCommand(KarmaWallet.TEMPLATE_ID, this.toValue(), "Spend", argValue);
  }

  public CreateAndExerciseCommand createAndExerciseSpend(String cId) {
    return createAndExerciseSpend(new Spend(cId));
  }

  public static CreateCommand create(String owner, WalletId id, String provider, String psid,
      WalletType walletType, BigDecimal amount, Instant creationTime, Instant modificationTime) {
    return new KarmaWallet(owner, id, provider, psid, walletType, amount, creationTime, modificationTime).create();
  }

  public static KarmaWallet fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<Record.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 8) {
      throw new IllegalArgumentException("Expected 8 arguments, got " + numberOfFields);
    }
    String owner = fields$.get(0).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected owner to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    WalletId id = WalletId.fromValue(fields$.get(1).getValue());
    String provider = fields$.get(2).getValue().asParty().orElseThrow(() -> new IllegalArgumentException("Expected provider to be of type com.daml.ledger.javaapi.data.Party")).getValue();
    String psid = fields$.get(3).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected psid to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    WalletType walletType = WalletType.fromValue(fields$.get(4).getValue());
    BigDecimal amount = fields$.get(5).getValue().asNumeric().orElseThrow(() -> new IllegalArgumentException("Expected amount to be of type com.daml.ledger.javaapi.data.Numeric")).getValue();
    Instant creationTime = fields$.get(6).getValue().asTimestamp().orElseThrow(() -> new IllegalArgumentException("Expected creationTime to be of type com.daml.ledger.javaapi.data.Timestamp")).getValue();
    Instant modificationTime = fields$.get(7).getValue().asTimestamp().orElseThrow(() -> new IllegalArgumentException("Expected modificationTime to be of type com.daml.ledger.javaapi.data.Timestamp")).getValue();
    return new hackademy.wallet.karma.KarmaWallet(owner, id, provider, psid, walletType, amount, creationTime, modificationTime);
  }

  public Record toValue() {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(8);
    fields.add(new Record.Field("owner", new Party(this.owner)));
    fields.add(new Record.Field("id", this.id.toValue()));
    fields.add(new Record.Field("provider", new Party(this.provider)));
    fields.add(new Record.Field("psid", new Text(this.psid)));
    fields.add(new Record.Field("walletType", this.walletType.toValue()));
    fields.add(new Record.Field("amount", new Numeric(this.amount)));
    fields.add(new Record.Field("creationTime", Timestamp.fromInstant(this.creationTime)));
    fields.add(new Record.Field("modificationTime", Timestamp.fromInstant(this.modificationTime)));
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
    if (!(object instanceof KarmaWallet)) {
      return false;
    }
    KarmaWallet other = (KarmaWallet) object;
    return this.owner.equals(other.owner) && this.id.equals(other.id) && this.provider.equals(other.provider) && this.psid.equals(other.psid) && this.walletType.equals(other.walletType) && this.amount.equals(other.amount) && this.creationTime.equals(other.creationTime) && this.modificationTime.equals(other.modificationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.owner, this.id, this.provider, this.psid, this.walletType, this.amount, this.creationTime, this.modificationTime);
  }

  @Override
  public String toString() {
    return String.format("hackademy.wallet.karma.KarmaWallet(%s, %s, %s, %s, %s, %s, %s, %s)", this.owner, this.id, this.provider, this.psid, this.walletType, this.amount, this.creationTime, this.modificationTime);
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<KarmaWallet> {
    public ContractId(String contractId) {
      super(contractId);
    }

    public ExerciseCommand exerciseReset_wallet(Reset_wallet arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(KarmaWallet.TEMPLATE_ID, this.contractId, "Reset_wallet", argValue);
    }

    public ExerciseCommand exerciseReset_wallet(BigDecimal resetAmount) {
      return exerciseReset_wallet(new Reset_wallet(resetAmount));
    }

    public ExerciseCommand exerciseAdd_Amount(Add_Amount arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(KarmaWallet.TEMPLATE_ID, this.contractId, "Add_Amount", argValue);
    }

    public ExerciseCommand exerciseAdd_Amount(BigDecimal addAmount) {
      return exerciseAdd_Amount(new Add_Amount(addAmount));
    }

    public ExerciseCommand exerciseArchive(Archive arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(KarmaWallet.TEMPLATE_ID, this.contractId, "Archive", argValue);
    }

    public ExerciseCommand exerciseSpend(Spend arg) {
      Value argValue = arg.toValue();
      return new ExerciseCommand(KarmaWallet.TEMPLATE_ID, this.contractId, "Spend", argValue);
    }

    public ExerciseCommand exerciseSpend(String cId) {
      return exerciseSpend(new Spend(cId));
    }
  }

  public static class Contract implements com.daml.ledger.javaapi.data.Contract {
    public final ContractId id;

    public final KarmaWallet data;

    public final Optional<String> agreementText;

    public final Optional<WalletId> key;

    public final Set<String> signatories;

    public final Set<String> observers;

    public Contract(ContractId id, KarmaWallet data, Optional<String> agreementText,
        Optional<WalletId> key, Set<String> signatories, Set<String> observers) {
      this.id = id;
      this.data = data;
      this.agreementText = agreementText;
      this.key = key;
      this.signatories = signatories;
      this.observers = observers;
    }

    public static Contract fromIdAndRecord(String contractId, Record record$,
        Optional<String> agreementText, Optional<WalletId> key, Set<String> signatories,
        Set<String> observers) {
      ContractId id = new ContractId(contractId);
      KarmaWallet data = KarmaWallet.fromValue(record$);
      return new Contract(id, data, agreementText, key, signatories, observers);
    }

    @Deprecated
    public static Contract fromIdAndRecord(String contractId, Record record$) {
      ContractId id = new ContractId(contractId);
      KarmaWallet data = KarmaWallet.fromValue(record$);
      return new Contract(id, data, Optional.empty(), Optional.empty(), Collections.emptySet(), Collections.emptySet());
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return fromIdAndRecord(event.getContractId(), event.getArguments(), event.getAgreementText(), event.getContractKey().map(e -> WalletId.fromValue(e)), event.getSignatories(), event.getObservers());
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
        return true;
      }
      if (object == null) {
        return false;
      }
      if (!(object instanceof Contract)) {
        return false;
      }
      Contract other = (Contract) object;
      return this.id.equals(other.id) && this.data.equals(other.data) && this.agreementText.equals(other.agreementText) && this.key.equals(other.key) && this.signatories.equals(other.signatories) && this.observers.equals(other.observers);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.data, this.agreementText, this.key, this.signatories, this.observers);
    }

    @Override
    public String toString() {
      return String.format("hackademy.wallet.karma.KarmaWallet.Contract(%s, %s, %s, %s, %s, %s)", this.id, this.data, this.agreementText, this.key, this.signatories, this.observers);
    }
  }
}

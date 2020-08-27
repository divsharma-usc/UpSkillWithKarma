package da.refapps.directassetcontrol;

import com.daml.ledger.javaapi.data.Contract;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.Identifier;
import hackademy.course.course.Course;
import hackademy.karma.karma.Karma;
import hackademy.kc.kc.KC;
import hackademy.roles.coursecreatorrole.CourseCreatorRole;
import hackademy.roles.coursecreatorrole.CourseCreatorRoleInvitation;
import hackademy.roles.operatorrole.OperatorRole;
import hackademy.wallet.karma.KarmaWallet;
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

public class Decoder {
  private static HashMap<Identifier, Function<CreatedEvent, Contract>> decoders;

  static {
    decoders = new HashMap<Identifier, Function<CreatedEvent, Contract>>();
    decoders.put(Karma.TEMPLATE_ID, Karma.Contract::fromCreatedEvent);
    decoders.put(KC.TEMPLATE_ID, KC.Contract::fromCreatedEvent);
    decoders.put(KarmaWallet.TEMPLATE_ID, KarmaWallet.Contract::fromCreatedEvent);
    decoders.put(Course.TEMPLATE_ID, Course.Contract::fromCreatedEvent);
    decoders.put(CourseCreatorRole.TEMPLATE_ID, CourseCreatorRole.Contract::fromCreatedEvent);
    decoders.put(CourseCreatorRoleInvitation.TEMPLATE_ID, CourseCreatorRoleInvitation.Contract::fromCreatedEvent);
    decoders.put(OperatorRole.TEMPLATE_ID, OperatorRole.Contract::fromCreatedEvent);
  }

  public static Contract fromCreatedEvent(CreatedEvent event) throws IllegalArgumentException {
    Identifier templateId = event.getTemplateId();
    Function<CreatedEvent, Contract> decoderFunc = getDecoder(templateId).orElseThrow(() -> new IllegalArgumentException("No template found for identifier " + templateId));
    return decoderFunc.apply(event);
  }

  public static Optional<Function<CreatedEvent, Contract>> getDecoder(Identifier templateId) {
    return Optional.ofNullable(decoders.get(templateId));
  }
}

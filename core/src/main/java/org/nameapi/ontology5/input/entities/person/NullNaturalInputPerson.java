package org.nameapi.ontology5.input.entities.person;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology5.cremalang.annotation.Immutable;
import org.nameapi.ontology5.input.entities.address.AddressRelation;
import org.nameapi.ontology5.input.entities.contact.EmailAddress;
import org.nameapi.ontology5.input.entities.contact.TelNumber;
import org.nameapi.ontology5.input.entities.person.age.AgeInfo;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.nameapi.ontology5.util.NameTransformer;
import org.nameapi.ontology5.util.ValueTransformer;

import java.util.Collections;
import java.util.List;

/**
 * Null-implementation of {@link InputPerson} that does not contain any information.
 * Mostly for testing.
 *
 * @author sam
 */
@Immutable
public class NullNaturalInputPerson implements NaturalInputPerson {

    private static final NullNaturalInputPerson INSTANCE = new NullNaturalInputPerson();

    /**
     * @return the singleton instance.
     */
    @NotNull
    public static NullNaturalInputPerson get() {
        return INSTANCE;
    }


    @NotNull @Override
    public StoragePersonGender getGender() {
        return StoragePersonGender.UNKNOWN;
    }

    @NotNull @Override
    public MaritalStatus getMaritalStatus() {
        return MaritalStatus.UNKNOWN;
    }


    @Override @NotNull
    public List<String> getNationalities() {
        return Collections.emptyList();
    }

    @Override @NotNull
    public List<String> getNativeLanguages() {
        return Collections.emptyList();
    }

    @Override @NotNull
    public Optional<String> getReligion() {
        return Optional.absent();
    }

    @Override @NotNull
    public Optional<InputPersonName> getPersonName() {
        return Optional.absent();
    }

    @Override @NotNull
    public Optional<AgeInfo> getAge() {
        return Optional.absent();
    }

    @Override @NotNull
    public List<AddressRelation> getAddresses() {
        return Collections.emptyList();
    }

    @Override @NotNull
    public List<TelNumber> getTelNumbers() {
        return Collections.emptyList();
    }

    @Override @NotNull
    public List<EmailAddress> getEmailAddresses() {
        return Collections.emptyList();
    }

    @Override @NotNull
    public Optional<String> getCorrespondenceLanguage() {
        return Optional.absent();
    }

    @Nullable
    @Override
    public InputPerson transform(@NotNull ValueTransformer transformer) {
        return this;
    }

    @Nullable
    @Override
    public InputPerson transform(@NotNull NameTransformer transformer) {
        return this;
    }

    /**
     * Not used, always throws!
     *
     * An actual implementation using Jackson could be:
     * <pre>
     *          ObjectMapper mapper = new ObjectMapper();
     *          try {
     *              return mapper.readValue(jsonRepresentation, InputWithEmail.class );
     *          } catch (IOException e) {
     *              throw new IllegalArgumentException("The json is not a valid representation of the object: \n" + jsonString);
     *         }
     * </pre>
     *
     * @throws UnsupportedOperationException This method is only here to comply with swagger server-side API requirements.
     */
    @NotNull
    public static NullNaturalInputPerson fromString(@NotNull String jsonString) {
        throw new UnsupportedOperationException("This method is only here to comply with swagger requirements.");
    }

}

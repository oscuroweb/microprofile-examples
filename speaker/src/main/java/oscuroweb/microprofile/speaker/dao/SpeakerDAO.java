package oscuroweb.microprofile.speaker.dao;

import oscuroweb.microprofile.speaker.model.Speaker;

import javax.enterprise.inject.Default;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Default
public class SpeakerDAO {

  private List<Speaker> speakerList =
      Arrays.asList(new Speaker[] {new Speaker(1l, "David", "Smith")});

  public Collection<Speaker> retrieveAll() {
    return speakerList;
  }

  public Optional<Speaker> retrieve(final Long id) {

    return speakerList.stream() // .filter(speaker -> id.equals(speaker.getId()))
        .findFirst();
  }

  public Speaker add(final Speaker speaker) {

    return speaker;
  }

  public Speaker update(final Speaker speaker) {

    return speaker;
  }

  public void delete(final Long id) {

    // TODO Remove

  }
}

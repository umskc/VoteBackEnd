package pl.plenczewski.voicesystem.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.plenczewski.voicesystem.model.Voices;

public interface VoicesRepository extends JpaRepository<Voices, Long> {
}

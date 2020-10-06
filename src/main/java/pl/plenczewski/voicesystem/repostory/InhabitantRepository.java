package pl.plenczewski.voicesystem.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.voicesystem.model.Inhabitant;

import java.util.Optional;

@Repository
public interface InhabitantRepository extends JpaRepository<Inhabitant, Long> {
    Optional<Inhabitant> findByNameAndSurnameAndStreetAndHomeNumberAndLocalNumber(String name, String surname, String street, String homeNumber, String localNumber);

}

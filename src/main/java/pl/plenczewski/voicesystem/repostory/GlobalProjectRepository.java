package pl.plenczewski.voicesystem.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.voicesystem.model.GlobalProject;

import java.util.List;

@Repository
public interface GlobalProjectRepository extends JpaRepository<GlobalProject, Long> {
    List<GlobalProject> findAllByIdIn(List<Long> ids);
}

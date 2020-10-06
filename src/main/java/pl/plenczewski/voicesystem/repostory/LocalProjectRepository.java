package pl.plenczewski.voicesystem.repostory;

import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.voicesystem.model.LocalProject;

import java.util.List;
import java.util.LongSummaryStatistics;

@Repository
public interface LocalProjectRepository extends JpaRepository<LocalProject, Long> {
    List<LocalProject> findAllByIdIn(List<Long> ids);
}

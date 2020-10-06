package pl.plenczewski.voicesystem.sevice;

import org.springframework.stereotype.Service;
import pl.plenczewski.voicesystem.model.GlobalProject;
import pl.plenczewski.voicesystem.model.LocalProject;

import java.util.List;

@Service
public interface ProjectsService {
    List<GlobalProject> getAllGlobalProjects();

    List<LocalProject> getAllLocalProjects();

}

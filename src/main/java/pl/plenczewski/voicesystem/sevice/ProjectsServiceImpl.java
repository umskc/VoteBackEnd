package pl.plenczewski.voicesystem.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.plenczewski.voicesystem.model.GlobalProject;
import pl.plenczewski.voicesystem.model.LocalProject;
import pl.plenczewski.voicesystem.repostory.GlobalProjectRepository;
import pl.plenczewski.voicesystem.repostory.LocalProjectRepository;

import java.util.List;


@Service
public class ProjectsServiceImpl implements ProjectsService {

    private GlobalProjectRepository globalProjectRepository;
    private LocalProjectRepository localProjectRepository;

    @Autowired
    public ProjectsServiceImpl(GlobalProjectRepository globalProjectRepository, LocalProjectRepository localProjectRepository) {
        this.globalProjectRepository = globalProjectRepository;
        this.localProjectRepository = localProjectRepository;
    }


    @Override
    public List<GlobalProject> getAllGlobalProjects() {
        return globalProjectRepository.findAll();
    }

    @Override
    public List<LocalProject> getAllLocalProjects() {
        return localProjectRepository.findAll();
    }
}

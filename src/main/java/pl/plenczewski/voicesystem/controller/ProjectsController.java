package pl.plenczewski.voicesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.plenczewski.voicesystem.model.GlobalProject;
import pl.plenczewski.voicesystem.model.LocalProject;
import pl.plenczewski.voicesystem.sevice.ProjectsService;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectsController {

    private ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping("/global")
    public List<GlobalProject> getGlobalProjects(){
        return projectsService.getAllGlobalProjects();
    }

    @GetMapping("/local")
    public List<LocalProject> getLocalProjects(){
        return projectsService.getAllLocalProjects();
    }
}

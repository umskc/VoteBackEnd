package pl.plenczewski.voicesystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Voices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<GlobalProject> globalProject;
    @ManyToMany
    private List<LocalProject> localProject;
    @OneToOne
    private Inhabitant inhabitant;

    public Voices() {
    }

    public Inhabitant getInhabitant() {
        return inhabitant;
    }

    public void setInhabitant(Inhabitant inhabitant) {
        this.inhabitant = inhabitant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GlobalProject> getGlobalProject() {
        return globalProject;
    }

    public void setGlobalProject(List<GlobalProject> globalProject) {
        this.globalProject = globalProject;
    }

    public List<LocalProject> getLocalProject() {
        return localProject;
    }

    public void setLocalProject(List<LocalProject> localProject) {
        this.localProject = localProject;
    }
}

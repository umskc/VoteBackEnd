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

    public Voices(Long id, List<GlobalProject> globalProjects, List<LocalProject> localProjects, Inhabitant inhabitant) {
        this.id = id;
        this.globalProject = globalProjects;
        this.localProject = localProjects;
        this.inhabitant = inhabitant;
    }

    public Inhabitant getInhabitant() {
        return inhabitant;
    }

    public Long getId() {
        return id;
    }

    public List<GlobalProject> getGlobalProject() {
        return globalProject;
    }

    public List<LocalProject> getLocalProject() {
        return localProject;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private List<GlobalProject> globalProjects;
        private List<LocalProject> localProjects;
        private Inhabitant inhabitant;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setGlobalProjects(List<GlobalProject> globalProjects) {
            this.globalProjects = globalProjects;
            return this;
        }

        public Builder setLocalProjects(List<LocalProject> localProjects) {
            this.localProjects = localProjects;
            return this;
        }

        public Builder setInhabitant(Inhabitant inhabitant) {
            this.inhabitant = inhabitant;
            return this;
        }

        public Voices build() {
            //todo validation
            return new Voices(id, globalProjects, localProjects, inhabitant);
        }
    }
}

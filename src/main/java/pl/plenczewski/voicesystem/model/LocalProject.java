package pl.plenczewski.voicesystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class LocalProject extends Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Zone zone;

    public LocalProject() {}

    public LocalProject(Long id, String title, Float totalCost, LocalDate deadLine, Zone zone) {
        this.id = id;
        this.title = title;
        this.totalCost = totalCost;
        this.deadLine = deadLine;
        this.zone = zone;
    }

    public Long getId() {
        return id;
    }

    public Zone getZone() {
        return zone;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {

        private Long id;
        private String title;
        private Float totalCost;
        private LocalDate deadLine;
        private Zone zone;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTotalCost(Float totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder setDeadLine(LocalDate deadLine) {
            this.deadLine = deadLine;
            return this;
        }

        public Builder setZone(Zone zone) {
            this.zone = zone;
            return this;
        }

        public LocalProject build() {
            //todo validation
            return new LocalProject(id, title, totalCost, deadLine, zone);
        }
    }

}

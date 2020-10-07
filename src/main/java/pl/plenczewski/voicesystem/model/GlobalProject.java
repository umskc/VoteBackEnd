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
public class GlobalProject extends Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public GlobalProject() {}

    public GlobalProject(Long id, String title, Float totalCost, LocalDate deadLine) {
        this.id = id;
        this.title = title;
        this.totalCost = totalCost;
        this.deadLine = deadLine;
    }

    public Long getId() {
        return id;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {

        private Builder() {}

        private Long id;
        private String title;
        private Float totalCost;
        private LocalDate deadLine;

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

        public GlobalProject build() {
            //todo validation
            return new GlobalProject(id, title, totalCost, deadLine);
        }
    }
}

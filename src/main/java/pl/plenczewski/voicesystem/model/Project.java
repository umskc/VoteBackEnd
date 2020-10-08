package pl.plenczewski.voicesystem.model;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Project {

        protected String title;
        protected Float totalCost;
        protected LocalDate deadLine;

        public String getTitle() {
                return title;
        }

        public Float getTotalCost() {
                return totalCost;
        }

        public LocalDate getDeadLine() {
                return deadLine;
        }
}

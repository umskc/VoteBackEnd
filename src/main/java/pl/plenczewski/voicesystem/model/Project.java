package pl.plenczewski.voicesystem.model;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Project {

        private String title;
        private Float totalCost;
        private LocalDate deadLine;


        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public Float getTotalCost() {
                return totalCost;
        }

        public void setTotalCost(Float totalCost) {
                this.totalCost = totalCost;
        }

        public LocalDate getDeadLine() {
                return deadLine;
        }

        public void setDeadLine(LocalDate deadLine) {
                this.deadLine = deadLine;
        }
}

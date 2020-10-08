package pl.plenczewski.voicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class VoteTokenVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String value;
    @OneToOne
    @JsonIgnore
    private Inhabitant inhabitant;

    public VoteTokenVerification() {
    }


    public VoteTokenVerification(String value, Inhabitant inhabitant) {
        this.value = value;
        this.inhabitant = inhabitant;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public Inhabitant getInhabitant() {
        return inhabitant;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public Builder() {

        }

        private String value;
        private Inhabitant inhabitant;

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Builder setInhabitant(Inhabitant inhabitant) {
            this.inhabitant = inhabitant;
            return this;
        }

        public VoteTokenVerification build() {
            if (value == null) {
                throw new IllegalStateException("Value cannot be null.");
            }
            if (inhabitant == null) {
                throw new IllegalStateException("Inhabitant cannot be null.");
            }
            return new VoteTokenVerification(value, inhabitant);
        }
    }
}

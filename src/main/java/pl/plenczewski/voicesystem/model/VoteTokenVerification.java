package pl.plenczewski.voicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Inhabitant getInhabitant() {
        return inhabitant;
    }

    public void setInhabitant(Inhabitant inhabitant) {
        this.inhabitant = inhabitant;
    }
}

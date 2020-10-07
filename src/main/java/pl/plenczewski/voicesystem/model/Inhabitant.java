package pl.plenczewski.voicesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inhabitant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String name;
    private String surname;
    private String street;
    private String homeNumber;
    private String localNumber;
    private boolean enabled;

    public Inhabitant() {
        this.setEnabled(true);
    }

    public Inhabitant(Long id, String name, String surname, String street, String homeNumber, String localNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.homeNumber = homeNumber;
        this.localNumber = localNumber;
        this.setEnabled(true);
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getSurname() {
        return surname;
    }

//    public void setSurname(String surname) {
//        this.surname = surname;
//    }

    public String getStreet() {
        return street;
    }

//    public void setStreet(String street) {
//        this.street = street;
//    }

    public String getHomeNumber() {
        return homeNumber;
    }

//    public void setHomeNumber(String homeNumber) {
//        this.homeNumber = homeNumber;
//    }

    public String getLocalNumber() {
        return localNumber;
    }

//    public void setLocalNumber(String localNumber) {
//        this.localNumber = localNumber;
//    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {

        public Builder() {}

        private Long id;
        private String name;
        private String surname;
        private String street;
        private String homeNumber;
        private String localNumber;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setHomeNumber(String homeNumber) {
            this.homeNumber = homeNumber;
            return this;
        }

        public Builder setLocalNumber(String localNumber) {
            this.localNumber = localNumber;
            return this;
        }

        public Inhabitant build() {
            return new Inhabitant(id, name, surname, street, homeNumber, localNumber);
        }

    }
}

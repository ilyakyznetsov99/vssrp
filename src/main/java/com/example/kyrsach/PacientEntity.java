package com.example.kyrsach;

import jakarta.persistence.*;

@Entity
@Table(name = "pacient", schema = "db")
public class PacientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpacient")
    private int idpacient;
    @Basic
    @Column(name = "fio")
    private String fio;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Basic
    @Column(name = "id_patient_card")
    private int idPatientCard;

    public int getIdpacient() {
        return idpacient;
    }

    public void setIdpacient(int idpacient) {
        this.idpacient = idpacient;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdPatientCard() {
        return idPatientCard;
    }

    public void setIdPatientCard(int idPatientCard) {
        this.idPatientCard = idPatientCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PacientEntity that = (PacientEntity) o;

        if (idpacient != that.idpacient) return false;
        if (idPatientCard != that.idPatientCard) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpacient;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + idPatientCard;
        return result;
    }
}

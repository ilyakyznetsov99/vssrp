package com.example.kyrsach;

import jakarta.persistence.*;

@Entity
@Table(name = "patient's_card", schema = "db")
public class PatientSCardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpatient'scard")
    private int idpatientScard;
    @Basic
    @Column(name = "symptoms")
    private String symptoms;
    @Basic
    @Column(name = "dyagnose")
    private String dyagnose;
    @Basic
    @Column(name = "medicine")
    private String medicine;
    @Basic
    @Column(name = "id_card")
    private int idCard;

    public int getIdpatientScard() {
        return idpatientScard;
    }

    public void setIdpatientScard(int idpatientScard) {
        this.idpatientScard = idpatientScard;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDyagnose() {
        return dyagnose;
    }

    public void setDyagnose(String dyagnose) {
        this.dyagnose = dyagnose;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientSCardEntity that = (PatientSCardEntity) o;

        if (idpatientScard != that.idpatientScard) return false;
        if (idCard != that.idCard) return false;
        if (symptoms != null ? !symptoms.equals(that.symptoms) : that.symptoms != null) return false;
        if (dyagnose != null ? !dyagnose.equals(that.dyagnose) : that.dyagnose != null) return false;
        if (medicine != null ? !medicine.equals(that.medicine) : that.medicine != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpatientScard;
        result = 31 * result + (symptoms != null ? symptoms.hashCode() : 0);
        result = 31 * result + (dyagnose != null ? dyagnose.hashCode() : 0);
        result = 31 * result + (medicine != null ? medicine.hashCode() : 0);
        result = 31 * result + idCard;
        return result;
    }
}

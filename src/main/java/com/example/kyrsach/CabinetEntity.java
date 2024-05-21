package com.example.kyrsach;

import jakarta.persistence.*;

@Entity
@Table(name = "cabinet", schema = "db")
public class CabinetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numcab")
    private int numcab;
    @Basic
    @Column(name = "purpose")
    private String purpose;

    public int getNumcab() {
        return numcab;
    }

    public void setNumcab(int numcab) {
        this.numcab = numcab;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CabinetEntity that = (CabinetEntity) o;

        if (numcab != that.numcab) return false;
        if (purpose != null ? !purpose.equals(that.purpose) : that.purpose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numcab;
        result = 31 * result + (purpose != null ? purpose.hashCode() : 0);
        return result;
    }
}

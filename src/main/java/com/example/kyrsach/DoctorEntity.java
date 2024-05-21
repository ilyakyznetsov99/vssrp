package com.example.kyrsach;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "doctor", schema = "db")
public class DoctorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iddoctor")
    private int iddoctor;
    @Basic
    @Column(name = "fio")
    private String fio;
    @Basic
    @Column(name = "numcab")
    private int numcab;
    @Basic
    @Column(name = "receptiontimefrom")
    private Time receptiontimefrom;
    @Basic
    @Column(name = "receptiontimeto")
    private Time receptiontimeto;

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getNumcab() {
        return numcab;
    }

    public void setNumcab(int numcab) {
        this.numcab = numcab;
    }

    public Time getReceptiontimefrom() {
        return receptiontimefrom;
    }

    public void setReceptiontimefrom(Time receptiontimefrom) {
        this.receptiontimefrom = receptiontimefrom;
    }

    public Time getReceptiontimeto() {
        return receptiontimeto;
    }

    public void setReceptiontimeto(Time receptiontimeto) {
        this.receptiontimeto = receptiontimeto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorEntity that = (DoctorEntity) o;

        if (iddoctor != that.iddoctor) return false;
        if (numcab != that.numcab) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (receptiontimefrom != null ? !receptiontimefrom.equals(that.receptiontimefrom) : that.receptiontimefrom != null)
            return false;
        if (receptiontimeto != null ? !receptiontimeto.equals(that.receptiontimeto) : that.receptiontimeto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iddoctor;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + numcab;
        result = 31 * result + (receptiontimefrom != null ? receptiontimefrom.hashCode() : 0);
        result = 31 * result + (receptiontimeto != null ? receptiontimeto.hashCode() : 0);
        return result;
    }
}

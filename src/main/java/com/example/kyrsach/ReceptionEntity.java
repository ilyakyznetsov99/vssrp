package com.example.kyrsach;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "reception", schema = "db")
public class ReceptionEntity {
    @Basic
    @Column(name = "iddoctor")
    private int iddoctor;
    @Basic
    @Column(name = "numkab")
    private int numkab;
    @Basic
    @Column(name = "dateofadmission")
    private Date dateofadmission;
    @Basic
    @Column(name = "pacientid")
    private int pacientid;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idreception")
    private int idreception;

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public int getNumkab() {
        return numkab;
    }

    public void setNumkab(int numkab) {
        this.numkab = numkab;
    }

    public Date getDateofadmission() {
        return dateofadmission;
    }

    public void setDateofadmission(Date dateofadmission) {
        this.dateofadmission = dateofadmission;
    }

    public int getPacientid() {
        return pacientid;
    }

    public void setPacientid(int pacientid) {
        this.pacientid = pacientid;
    }

    public int getIdreception() {
        return idreception;
    }

    public void setIdreception(int idreception) {
        this.idreception = idreception;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceptionEntity that = (ReceptionEntity) o;

        if (iddoctor != that.iddoctor) return false;
        if (numkab != that.numkab) return false;
        if (pacientid != that.pacientid) return false;
        if (idreception != that.idreception) return false;
        if (dateofadmission != null ? !dateofadmission.equals(that.dateofadmission) : that.dateofadmission != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iddoctor;
        result = 31 * result + numkab;
        result = 31 * result + (dateofadmission != null ? dateofadmission.hashCode() : 0);
        result = 31 * result + pacientid;
        result = 31 * result + idreception;
        return result;
    }
}

package ar.com.gep.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car")
public class Car implements Serializable {

    private static final long serialVersionUID = 4850561970178844269L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "anio")
    private Integer year;

    @Column(name = "compania")
    private String company;

    public Car(Integer year, String company) {
        this.year = year;
        this.company = company;
    }

    public Car() {
        this.year = null;
        this.company = null;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

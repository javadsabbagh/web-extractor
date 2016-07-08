package com.dev.web.extr.model.entity;

import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
/**
 *
 * @author Sabbagh
 */ 
@Entity
@Table(name="Employee", uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Employee implements Serializable {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;
     
    @Column(name="NAME", length=20, nullable=true)
    private String name;
     
    @Column(name="ROLE", length=20, nullable=true)
    private String role;
     
    @Column(name="insert_time", nullable=true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date insertTime;
     
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Date getInsertTime() {
        return insertTime;
    }
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}
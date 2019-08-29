package com.donovanuy.mixmix.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdDate", "createdBy",
                "LastModifiedDate", "LastModifiedBy"},
        allowGetters = true
)

public abstract class AuditModel implements Serializable{

    // From AuditModel

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;


    // @Column(name = "created_by", nullable = false, updatable = false)
    // @CreatedBy
    // private Mixmixer createdBy;

    // @Column(name = "last_modified_by", nullable = false)
    // @LastModifiedBy
    // private Mixmixer lastModifiedBy;

    // Setters & Getters

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // public Mixmixer getCreatedBy() {
    //     return this.createdBy;
    // }

    // public void setCreatedBy(Mixmixer createdBy) {
    //     this.createdBy = createdBy;
    // }

    // public Mixmixer getLastModifiedBy() {
    //     return this.lastModifiedBy;
    // }

    // public void setLastModifiedBy(Mixmixer lastModifiedBy) {
    //     this.lastModifiedBy = lastModifiedBy;
    // }

    // more setters and getters



}
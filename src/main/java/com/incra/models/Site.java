package com.incra.models;

import com.incra.database.AbstractDatabaseItem;
import com.incra.database.AbstractTimeStampableDatabaseItem;

import javax.persistence.*;

/**
 * Stores site info
 */
@Entity(name = "site")
public class Site extends AbstractTimeStampableDatabaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String name;

    @Basic
    private String customCSS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomCSS() {
        return customCSS;
    }

    public void setCustomCSS(String customCSS) {
        this.customCSS = customCSS;
    }
}
package com.incra.models;

import com.incra.database.AbstractTimeStampableDatabaseItem;

import javax.persistence.*;

/**
 * Region on a page
 *
 * @author Jeff Risberg
 * @since February 2014
 */
@Entity(name = "box")
public class Box extends AbstractTimeStampableDatabaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // type must go here somewhere

    @Basic
    private String title;

    @Basic
    @Column(name = "seq_num")
    private Integer seqNum;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private Site site;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;

        Box rubric = (Box) o;

        if (!title.equals(rubric.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("Rubric[title=");
        sb.append(title);
        sb.append("]");

        return sb.toString();
    }
}
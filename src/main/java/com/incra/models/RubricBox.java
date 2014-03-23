package com.incra.models;

import com.incra.database.AbstractTimeStampableDatabaseItem;

import javax.persistence.*;

/**
 * Region on a page
 *
 * @author Jeff Risberg
 * @since February 2014
 */
@Entity(name = "rubric_box")
public class RubricBox extends AbstractTimeStampableDatabaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "rubric_id", nullable = false)
    protected Rubric rubric;

    @ManyToOne
    @JoinColumn(name = "box_id", nullable = false)
    protected Box box;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RubricBox)) return false;

        RubricBox rubricBox = (RubricBox) o;

        if (!box.equals(rubricBox.box)) return false;
        if (!rubric.equals(rubricBox.rubric)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rubric.hashCode();
        result = 31 * result + box.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("RubricBox[rubric_id=");
        sb.append(rubric.getId());
        sb.append("]");

        return sb.toString();
    }
}
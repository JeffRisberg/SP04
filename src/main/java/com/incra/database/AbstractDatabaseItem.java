package com.incra.database;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

/**
 * The <i>AbstractDomain</i> class is the superclass of entities. It provides
 * standard fields for tracking usage.
 * 
 * @author Jeffrey Risberg
 * @since 09/10/11
 */
@MappedSuperclass
public abstract class AbstractDatabaseItem implements Serializable {
  private Date dateCreated;
  private Date lastUpdated;

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
}

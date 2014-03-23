package com.incra.services;

import com.incra.models.Site;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * The <i>SiteService</i> provides support for persistence of Site
 *
 * @author Jeffrey Risberg
 * @since 12/06/11
 */
@Transactional
@Repository
public class SiteService {

    @PersistenceContext
    private EntityManager em;

    public List<Site> findEntityList() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Site> criteria = cb.createQuery(Site.class);
        criteria.from(Site.class);

        return em.createQuery(criteria).getResultList();
    }

    public Site findEntityById(Integer id) {
        return em.find(Site.class, id);
    }

}

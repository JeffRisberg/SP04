package com.incra.services;

import com.incra.models.Image;
import com.incra.models.Site;
import com.incra.services.exception.ImageException;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

/**
 * The <i>ImageService</i> handles the JPA-based updating of Image entities.
 *
 * @author Jeffrey Risberg
 * @since February 2015
 */
@Transactional
@Repository
public class ImageService {
    protected static Logger logger = LoggerFactory.getLogger(ImageService.class);

    @PersistenceContext
    private EntityManager em;

    public List<Site> findEntityList() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Site> criteria = cb.createQuery(Site.class);
        criteria.from(Site.class);

        return em.createQuery(criteria).getResultList();
    }

    public Site findEntityById(int id) {
        return em.find(Site.class, id);
    }

    public Site findEntityByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Site> criteria = builder.createQuery(Site.class);
        Root<Site> root = criteria.from(Site.class);

        Path<String> rootName = root.get("name");
        criteria.where(builder.equal(rootName, name));

        try {
            return em.createQuery(criteria).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void save(Site site) {
        if (site.getId() == null || site.getId() == 0) {
            em.persist(site);
        } else {
            em.merge(site);
        }
    }

    public void delete(Site site) {
        this.delete(site.getId());
    }

    public void delete(int siteId) {
        Site existingSite = this.findEntityById(siteId);
        if (null != existingSite) {
            em.remove(existingSite);
        }
    }

    private BufferedImage resizeImage(Image image, int width, int height) throws ImageException {
        BufferedImage originalImage = readImage(image);

        if (originalImage == null) {
            logger.error("null BufferedImage returned");
            throw new ImageException("MSG_SAVE_IMAGE_ERROR");
        }

        BufferedImage resizedImage = null;
        if (originalImage.getWidth() > width || originalImage.getHeight() > height) {
            /* Is there any reason we would ever want to do this? Preserving for now
            float imageRatio = ((float) originalImage.getHeight() / (float) originalImage.getWidth());
            float targetRatio = ((float) height / (float) width);
            if (imageRatio <= targetRatio) {
                resizedImage = Scalr.resize(originalImage, Scalr.Mode.FIT_TO_WIDTH, width, height);
            } else if (imageRatio > targetRatio) {
                resizedImage = Scalr.resize(originalImage, Scalr.Mode.FIT_TO_HEIGHT, width, height);
            }
            */

            // Always fit to width
            resizedImage = Scalr.resize(originalImage, Scalr.Mode.FIT_TO_WIDTH, width, height);

            if (resizedImage == null) {
                logger.error("null BufferedImage returned");
                throw new ImageException("MSG_SAVE_IMAGE_ERROR");
            }
        } else {
            resizedImage = originalImage;
        }

        setDimensions(image, resizedImage);
        return resizedImage;
    }

    private BufferedImage readImage(Image image) throws ImageException {
        try {
            logger.debug("reading Image file: " + image.getAbsolutePath());
            return ImageIO.read(new File(image.getAbsolutePath()));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ImageException("Error reading image data from file");
        }
    }

    /**
     * Sets the width and height attributes of an Image based on data from the source file.
     *
     * @throws ImageException if there is a problem reading Image from file
     */
    public void setDimensions(Image image, BufferedImage sourceImage) throws ImageException {
        int width = sourceImage.getWidth(null);
        int height = sourceImage.getHeight(null);
        logger.debug("Setting image width/height: " + width + "/" + height);

        image.setWidth(width);
        image.setHeight(height);
    }
}

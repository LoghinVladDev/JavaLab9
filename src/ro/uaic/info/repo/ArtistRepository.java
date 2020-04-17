package ro.uaic.info.repo;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import ro.uaic.info.entity.Artists;
import ro.uaic.info.util.PersistenceUtil;

import javax.persistence.*;

import java.util.List;

public class ArtistRepository {
    public static void create(Artists artist){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static Artists findByID(int ID){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        Artists lookFor = new Artists();
        lookFor.setId(ID);
        Artists artist = entityManager.find(Artists.class, lookFor.getId());

        entityManager.close();

        return artist;
    }

    public static List<Artists> findByName(String name){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        TypedQuery<Artists> namedQuery = entityManager.createNamedQuery("findArtistsByName", Artists.class);
        namedQuery.setParameter("artistName", name);

        List<Artists> artistsList = namedQuery.getResultList();
        entityManager.close();

        return artistsList;
    }

    public static List<Artists> findByNamePattern(String pattern){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        TypedQuery<Artists> namedQuery = entityManager.createNamedQuery("findArtistsByNameRegex", Artists.class);
        namedQuery.setParameter(1, pattern);

        List<Artists> artistsList = namedQuery.getResultList();
        entityManager.close();

        return artistsList;
    }
}

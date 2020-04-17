package ro.uaic.info.repo;

import ro.uaic.info.entity.Albums;
import ro.uaic.info.entity.Artists;
import ro.uaic.info.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

public class AlbumRepository {
    public static void create(Albums album){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static Albums findByID(int ID){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        Albums lookFor = new Albums();
        lookFor.setId(ID);
        Albums album = entityManager.find(Albums.class, lookFor.getId());

        entityManager.close();

        return album;
    }

    public static List<Albums> findByName(String name){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        TypedQuery<Albums> query = entityManager.createNamedQuery("findAlbumsByName", Albums.class);
        query.setParameter("albumName", name);

        List<Albums> albumsList = query.getResultList();
        entityManager.close();

        return albumsList;
    }

    public static List<Albums> findByNamePattern(String pattern){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        TypedQuery<Albums> query = entityManager.createNamedQuery("findAlbumsByNameRegex", Albums.class);
        query.setParameter(1, pattern);

        List<Albums> albumsList = query.getResultList();
        entityManager.close();

        return albumsList;
    }

    public static List<Albums> findByArtists(Artists artist){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        TypedQuery<Albums> query = entityManager.createNamedQuery("findAlbumsByArtist", Albums.class);
        query.setParameter("artistID", artist.getId());

        List<Albums> albumsList = query.getResultList();
        entityManager.close();

        return albumsList;
    }
}

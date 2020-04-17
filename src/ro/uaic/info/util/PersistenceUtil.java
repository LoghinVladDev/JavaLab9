package ro.uaic.info.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil instance;
    private EntityManagerFactory entityManagerFactory;

    public static PersistenceUtil getInstance() {
        if(PersistenceUtil.instance == null)
            PersistenceUtil.instance = new PersistenceUtil();
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.entityManagerFactory;
    }

    private PersistenceUtil(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }
}

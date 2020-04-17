package ro.uaic.info.app;

import ro.uaic.info.entity.Albums;
import ro.uaic.info.entity.Artists;
import ro.uaic.info.repo.AlbumRepository;
import ro.uaic.info.repo.ArtistRepository;
import ro.uaic.info.util.PersistenceUtil;

public class AlbumManager {
    public static void main(String[] args) {
        /*Artists a = new Artists();

        a.setName("testname3");
        a.setCountry("testcntr1");

        ArtistRepository.create(a);
*/
        System.out.println(ArtistRepository.findByID(5013));

        System.out.println(ArtistRepository.findByName("Mrs. Tommie Bergnaum"));

        System.out.println(ArtistRepository.findByNamePattern("%a"));

        System.out.println(AlbumRepository.findByID(6175));

        System.out.println(AlbumRepository.findByName("Shall not Perish Avery, Stage And Screen"));

        System.out.println(AlbumRepository.findByNamePattern("%a%"));

        System.out.println(AlbumRepository.findByArtists(
                ArtistRepository.findByID(5013)
        ));

        PersistenceUtil.getInstance().getEntityManagerFactory().close();
    }
}

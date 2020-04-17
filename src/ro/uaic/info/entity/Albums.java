package ro.uaic.info.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Albums {
    private int id;
    private String name;
    private int artistId;
    private Integer releaseYear;
    private Artists artistsByArtistId;
    private Collection<ChartPositions> chartPositionsById;

    public String toString(){
        return "Album id = " +
                this.id +
                " name = " +
                this.name +
                " artist_id = " +
                this.artistId +
                " release_year = " +
                this.releaseYear;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "artist_id")
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "release_year")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albums albums = (Albums) o;
        return id == albums.id &&
                artistId == albums.artistId &&
                Objects.equals(name, albums.name) &&
                Objects.equals(releaseYear, albums.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artistId, releaseYear);
    }

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "ID", nullable = false)
    public Artists getArtistsByArtistId() {
        return artistsByArtistId;
    }

    public void setArtistsByArtistId(Artists artistsByArtistId) {
        this.artistsByArtistId = artistsByArtistId;
    }

    @OneToMany(mappedBy = "albumsByAlbumId")
    public Collection<ChartPositions> getChartPositionsById() {
        return chartPositionsById;
    }

    public void setChartPositionsById(Collection<ChartPositions> chartPositionsById) {
        this.chartPositionsById = chartPositionsById;
    }
}

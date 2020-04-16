package ro.uaic.info.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chart_positions", schema = "music_albums", catalog = "")
public class ChartPositions {
    private int id;
    private int chartId;
    private int albumId;
    private int position;
    private Charts chartsByChartId;
    private Albums albumsByAlbumId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "chart_ID")
    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    @Basic
    @Column(name = "album_ID")
    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Basic
    @Column(name = "position")
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartPositions that = (ChartPositions) o;
        return id == that.id &&
                chartId == that.chartId &&
                albumId == that.albumId &&
                position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chartId, albumId, position);
    }

    @ManyToOne
    @JoinColumn(name = "chart_ID", referencedColumnName = "ID", nullable = false)
    public Charts getChartsByChartId() {
        return chartsByChartId;
    }

    public void setChartsByChartId(Charts chartsByChartId) {
        this.chartsByChartId = chartsByChartId;
    }

    @ManyToOne
    @JoinColumn(name = "album_ID", referencedColumnName = "ID", nullable = false)
    public Albums getAlbumsByAlbumId() {
        return albumsByAlbumId;
    }

    public void setAlbumsByAlbumId(Albums albumsByAlbumId) {
        this.albumsByAlbumId = albumsByAlbumId;
    }
}

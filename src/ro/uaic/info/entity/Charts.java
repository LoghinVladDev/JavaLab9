package ro.uaic.info.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Charts {
    private int id;
    private String name;
    private Collection<ChartPositions> chartPositionsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charts charts = (Charts) o;
        return id == charts.id &&
                Objects.equals(name, charts.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "chartsByChartId")
    public Collection<ChartPositions> getChartPositionsById() {
        return chartPositionsById;
    }

    public void setChartPositionsById(Collection<ChartPositions> chartPositionsById) {
        this.chartPositionsById = chartPositionsById;
    }
}

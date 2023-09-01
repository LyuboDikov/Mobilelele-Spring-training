package bg.softuni.Mobilelele.models.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Table(name = "brands")
@Entity
public class Brand extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "brand",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Model> models = new ArrayList<>();

    public Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}

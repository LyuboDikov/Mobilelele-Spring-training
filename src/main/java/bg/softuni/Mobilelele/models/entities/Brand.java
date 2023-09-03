package bg.softuni.Mobilelele.models.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Table(name = "brands")
@Entity
public class Brand extends BaseEntity {

    private String name;
    private List<Model> models = new ArrayList<>();

    public Brand() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(
            mappedBy = "brand",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
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

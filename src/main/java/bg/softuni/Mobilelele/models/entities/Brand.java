package bg.softuni.Mobilelele.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    private String name;
    @OneToMany(
            mappedBy = "brand",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Model> models = new ArrayList<>();

}

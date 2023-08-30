package bg.softuni.Mobilelele.models.entities;

import bg.softuni.Mobilelele.models.enums.Category;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    //•	name – a model name.
    //•	category – an enumeration (Car, Buss, Truck, Motorcycle)
    //•	imageUrl – the url of image with size between 8 and 512 characters.
    //•	startYear – a number.
    //•	endYear – a number.
    //•	created – a date and time.
    //•	modified – a date and time.
    //•	brand – a model brand.

    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    @ManyToOne
    private Brand brand;

}

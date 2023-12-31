package bg.softuni.Mobilelele.models.dtos;

import java.util.ArrayList;
import java.util.List;

public class BrandDto {

    private String name;
    private List<ModelDto> models;

    public BrandDto() {
    }

    public List<ModelDto> getModels() {
        return models;
    }

    public void setModels(List<ModelDto> models) {
        this.models = models;
    }

    public void addModel(ModelDto model) {

        if (this.models == null) {
            this.models = new ArrayList<>();
        }

        this.models.add(model);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

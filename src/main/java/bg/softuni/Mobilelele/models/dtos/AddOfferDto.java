package bg.softuni.Mobilelele.models.dtos;

import bg.softuni.Mobilelele.models.enums.EngineEnum;
import bg.softuni.Mobilelele.models.enums.TransmissionEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AddOfferDto {

    private EngineEnum engine;
    private String imageUrl;

    private TransmissionEnum transmission;

    public AddOfferDto() {
    }

    @NotNull
    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    @NotEmpty
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NotNull
    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }
}

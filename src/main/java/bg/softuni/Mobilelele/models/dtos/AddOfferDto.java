package bg.softuni.Mobilelele.models.dtos;

import bg.softuni.Mobilelele.models.enums.EngineEnum;
import bg.softuni.Mobilelele.models.enums.TransmissionEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AddOfferDto {

    private Long modelId;
    private EngineEnum engine;
    private String imageUrl;
    private TransmissionEnum transmission;
    private Integer price;
    private Integer year;
    private Integer mileage;
    private String description;

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

    @NotNull
    @Positive
    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    @Positive
    @NotNull
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @NotNull
    @Min(1900)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @NotEmpty
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

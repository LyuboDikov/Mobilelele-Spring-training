package bg.softuni.Mobilelele.services;

import bg.softuni.Mobilelele.models.dtos.AddOfferDto;
import bg.softuni.Mobilelele.models.dtos.BrandDto;

import java.util.List;

public interface OfferService {

    void addOffer(AddOfferDto addOfferDto);
    List<BrandDto> getAllBrands();
}

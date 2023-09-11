package bg.softuni.Mobilelele.models.mapper;

import bg.softuni.Mobilelele.models.dtos.AddOfferDto;
import bg.softuni.Mobilelele.models.entities.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {
    Offer addOfferDtoToOffer(AddOfferDto addOfferDto);
}

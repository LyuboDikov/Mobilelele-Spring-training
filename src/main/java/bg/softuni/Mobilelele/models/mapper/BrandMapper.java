package bg.softuni.Mobilelele.models.mapper;

import bg.softuni.Mobilelele.models.dtos.BrandDto;
import bg.softuni.Mobilelele.models.dtos.ModelDto;
import bg.softuni.Mobilelele.models.entities.Brand;
import bg.softuni.Mobilelele.models.entities.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "models", source = "models")
    BrandDto brandToBrandDto(Brand brand);
    List<ModelDto> mapModels(List<Model> models);
}

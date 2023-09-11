package bg.softuni.Mobilelele.services.impl;

import bg.softuni.Mobilelele.models.dtos.BrandDto;
import bg.softuni.Mobilelele.models.mapper.BrandMapper;
import bg.softuni.Mobilelele.repositories.BrandRepository;
import bg.softuni.Mobilelele.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandMapper brandMapper;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandMapper brandMapper, BrandRepository brandRepository) {
        this.brandMapper = brandMapper;
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDto> getAllBrands() {
      return brandRepository.
              findAll().
              stream().
              map(brandMapper::brandToBrandDto).
              toList();
    }
}

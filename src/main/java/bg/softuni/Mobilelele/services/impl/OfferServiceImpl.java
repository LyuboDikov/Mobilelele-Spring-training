package bg.softuni.Mobilelele.services.impl;

import bg.softuni.Mobilelele.models.dtos.AddOfferDto;
import bg.softuni.Mobilelele.models.dtos.BrandDto;
import bg.softuni.Mobilelele.models.entities.Model;
import bg.softuni.Mobilelele.models.entities.Offer;
import bg.softuni.Mobilelele.models.entities.User;
import bg.softuni.Mobilelele.models.mapper.OfferMapper;
import bg.softuni.Mobilelele.repositories.ModelRepository;
import bg.softuni.Mobilelele.repositories.OfferRepository;
import bg.softuni.Mobilelele.repositories.UserRepository;
import bg.softuni.Mobilelele.services.BrandService;
import bg.softuni.Mobilelele.services.OfferService;
import bg.softuni.Mobilelele.users.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferMapper offerMapper;
    private final BrandService brandService;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(BrandService brandService,
                            OfferRepository offerRepository,
                            OfferMapper offerMapper,
                            UserRepository userRepository,
                            CurrentUser currentUser,
                            ModelRepository modelRepository) {
        this.brandService = brandService;
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }

    @Override
    public void addOffer(AddOfferDto addOfferDto) {

        Offer newOffer = offerMapper.addOfferDtoToOffer(addOfferDto);

        User seller = userRepository.findByEmail(currentUser.getEmail()).
                orElseThrow();

        Model model = modelRepository.findById(addOfferDto.getModelId()).
                orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);

    }

    @Override
    public List<BrandDto> getAllBrands() {
        return brandService.getAllBrands();
    }
}

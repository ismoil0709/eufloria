package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Address;
import uz.pdp.eufloria.dto.AddressDto;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.exception.NullOrEmptyException;
import uz.pdp.eufloria.repository.AddressRepository;
import uz.pdp.eufloria.service.AddressService;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public AddressDto save(AddressDto addressDto) {
        if (addressDto == null) {
            throw new NullOrEmptyException("AddressDto");
        }
        Address address2 = addressRepository.save(Address.builder()
                .country(addressDto.getCountry())
                .city(addressDto.getCity())
                .street(addressDto.getStreet())
                .home(addressDto.getHome())
                .build());
        return new AddressDto(address2);
    }

    @Override
    public List<AddressDto> getAllAddresss() {
        return addressRepository.findAll().stream().map(AddressDto::new).toList();
    }

    @Override
    public AddressDto getById(Long id) {
        if(id == null) {
            throw new NullOrEmptyException("id");
        }
        return new AddressDto(addressRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Address")
        ));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return true;
        }
        return false;
    }

}

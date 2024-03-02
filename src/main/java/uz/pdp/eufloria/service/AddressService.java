package uz.pdp.eufloria.service;

import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Address;
import uz.pdp.eufloria.dto.AddressDto;

import java.util.List;


@Service
public interface AddressService {

    AddressDto save(AddressDto addressDto);

    List<AddressDto> getAllAddresss();

    AddressDto getById(Long id);

    boolean delete(Long id);
}

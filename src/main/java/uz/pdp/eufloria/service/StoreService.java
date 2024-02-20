package uz.pdp.eufloria.service;

import org.springframework.stereotype.Service;
import uz.pdp.eufloria.dto.StoreDto;

import java.time.LocalTime;
import java.util.List;

@Service
public interface StoreService {
    StoreDto save(StoreDto storeDto);
    StoreDto update(StoreDto storeDto);
    void delete(Long id);
    StoreDto getById(Long id);
    StoreDto getByName(String name);
    List<StoreDto> getAll();
    List<StoreDto> getAllByOpens(LocalTime opens);
    List<StoreDto> getAllByCloses(LocalTime closes);
}

package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Store;
import uz.pdp.eufloria.dto.StoreDto;
import uz.pdp.eufloria.exception.AlreadyExistsException;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.exception.NullOrEmptyException;
import uz.pdp.eufloria.repository.StoreRepository;
import uz.pdp.eufloria.service.StoreService;
import uz.pdp.eufloria.util.Validator;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    @Override
    public StoreDto save(StoreDto storeDto) {
        if (storeDto == null)
            throw new NotFoundException("Store");
        if (Validator.isNullOrEmpty(storeDto.getName()))
            throw new NullOrEmptyException("Store name");
        if (storeDto.getOpens() == null)
            throw new NullOrEmptyException("Store opens");
        if (storeDto.getCloses() == null)
            throw new NullOrEmptyException("Store closes");
        if (storeDto.getId() != null) {
            if (storeRepository.findById(storeDto.getId()).isPresent())
                throw new AlreadyExistsException("Store id");
        }
        if (storeRepository.findByName(storeDto.getName()).isPresent())
            throw new AlreadyExistsException("Store name");

        return new StoreDto(storeRepository.save(convertToEntity(storeDto)));
    }

    @Override
    public StoreDto update(StoreDto storeDto) {
        if (storeDto == null)
            throw new NotFoundException("Store");
        if (storeDto.getId() == null)
            throw new NullOrEmptyException("Store id");

        Store existingStore = storeRepository.findById(storeDto.getId())
                .orElseThrow(() -> new NotFoundException("Store"));

        Store updatedStore = Store.builder()
                .id(existingStore.getId())
                .name(Validator.requireNonNullElse(storeDto.getName(), existingStore.getName()))
                .opens(Validator.requireNonNullElse(storeDto.getOpens(), existingStore.getOpens()))
                .closes(Validator.requireNonNullElse(storeDto.getCloses(), existingStore.getCloses()))
                .build();

        return new StoreDto(storeRepository.save(updatedStore));
    }

    @Override
    public void delete(Long id) {
        if (id == null)
            throw new NullOrEmptyException("Store id");

        if (!storeRepository.existsById(id))
            throw new NotFoundException("Store");

        storeRepository.deleteById(id);
    }

    @Override
    public StoreDto getById(Long id) {
        if (id == null)
            throw new NullOrEmptyException("Store id");

        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Store"));

        return new StoreDto(store);
    }

    @Override
    public StoreDto getByName(String name) {
        if (name == null)
            throw new NullOrEmptyException("Store name");

        Store store = storeRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Store"));

        return new StoreDto(store);
    }

    @Override
    public List<StoreDto> getAll() {
        return storeRepository.findAll().stream().map(StoreDto::new).toList();
    }

    @Override
    public List<StoreDto> getAllByOpens(LocalTime opens) {
        if (opens == null)
            throw new NullOrEmptyException("Opens time");

        return storeRepository.findAllByOpens(opens).stream().map(StoreDto::new).toList();
    }

    @Override
    public List<StoreDto> getAllByCloses(LocalTime closes) {
        if (closes == null)
            throw new NullOrEmptyException("Closes time");

        return storeRepository.findAllByCloses(closes).stream().map(StoreDto::new).toList();
    }

    private Store convertToEntity(StoreDto storeDto) {
        return Store.builder()
                .id(storeDto.getId())
                .name(storeDto.getName())
                .opens(storeDto.getOpens())
                .closes(storeDto.getCloses())
                .build();
    }
}

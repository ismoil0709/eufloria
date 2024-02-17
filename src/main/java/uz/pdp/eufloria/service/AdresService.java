package uz.pdp.eufloria.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.repo.AdresRepository;

@Service
@RequiredArgsConstructor
public class AdresService {
    private final AdresRepository adresRepository;

}

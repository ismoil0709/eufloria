package uz.pdp.eufloria.service;

import org.springframework.stereotype.Service;
import uz.pdp.eufloria.dto.request.AddPictureDto;
import uz.pdp.eufloria.dto.request.PictureDeleteDto;

@Service
public interface PictureService {
    void save(AddPictureDto pictureCreateDto);
    void delete(PictureDeleteDto pictureDeleteDto);
}

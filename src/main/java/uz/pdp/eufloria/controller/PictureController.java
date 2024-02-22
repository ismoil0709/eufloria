package uz.pdp.eufloria.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eufloria.dto.request.AddPictureDto;
import uz.pdp.eufloria.dto.request.PictureDeleteDto;
import uz.pdp.eufloria.service.PictureService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/picture")
@RequiredArgsConstructor
public class PictureController {
    private final PictureService pictureService;
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid AddPictureDto pictureCreateDto){
        pictureService.save(pictureCreateDto);
        return ResponseEntity.ok(Map.of("message","Picture successfully added"));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody @Valid PictureDeleteDto pictureDeleteDto){
        pictureService.delete(pictureDeleteDto);
        return ResponseEntity.ok(Map.of("message", "Picture successfully deleted"));
    }
}

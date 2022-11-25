package com.example.demo.vandalism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vandalism")

public class VandalismController {


    private final VandalismService vandalismService;


    @GetMapping(path = "{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {

        FileSystemResource imgFile = new FileSystemResource("C:/Users/user/Desktop/Тимофей проект/"+imageName );

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());

    }

    @PostMapping(value = "/postImage/{name}")
    public void postImage(@PathVariable("name") String fileName, @RequestPart("file") MultipartFile file){

        vandalismService.addImage(fileName,file);

    }



    @Autowired
    public VandalismController(VandalismService vandalismService) {
        this.vandalismService = vandalismService;
    }

    @GetMapping
    public List<Vandalism> getAllVandalism(){
        return vandalismService.getVandalism();
    }



    @PostMapping
    public void registerNewVandalism(@RequestBody Vandalism vandalism){
    vandalismService.addNewVandalism(vandalism);
    }

    @DeleteMapping(path = "{vandalismId}")
    public void deleteVandalism(@PathVariable("vandalismId") Long vandalismId){
    vandalismService.deleteVandalism(vandalismId);

    }



    @PutMapping(path = "{vandalismId}")
    public void putVandalism(
            @PathVariable("vandalismId") Long vandalismId,
            @RequestParam(required = false) Double lat,
            @RequestParam(required = false) Double lon,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String object,
            @RequestParam(required = false) Long votes,
            @RequestParam(required = false) String imageName,
            @RequestParam(required = false) Boolean cleaned) {

    vandalismService.updateVandalism(vandalismId,lat,lon,address,type,object,votes,imageName,cleaned);
    }
}

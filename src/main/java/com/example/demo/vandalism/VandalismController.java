package com.example.demo.vandalism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vandalism")

public class VandalismController {


    private final VandalismService vandalismService;

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


    //todo переделать метод upgrade
    @PutMapping(path = "{vandalismId}")
    public void putVandalism(
            @PathVariable("vandalismId") Long vandalismId,
            @RequestParam(required = false) Double lat,
            @RequestParam(required = false) Double lon,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String object,
            @RequestParam(required = false) Boolean cleaned) {

vandalismService.updateVandalism(vandalismId,lat,lon,address,type,object,cleaned);
    }
}

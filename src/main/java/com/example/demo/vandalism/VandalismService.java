package com.example.demo.vandalism;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class VandalismService {

    private final VandalismRepository vandalismRepository;

    //ready
    @Autowired
    public VandalismService(VandalismRepository vandalismRepository) {
        this.vandalismRepository = vandalismRepository;
    }

    //ready
    @GetMapping
    public List<Vandalism> getVandalism(){
        return vandalismRepository.findAll();
    }


    //ready
    public void addNewVandalism(Vandalism vandalism) {
        Optional<Vandalism> vandalismOptional = vandalismRepository
                .findVandalismByLatLon(vandalism.getLat(),vandalism.getLon());
        if (vandalismOptional.isPresent()){
            throw new IllegalStateException("already exists");
        }
       vandalismRepository.save(vandalism);
    }

    //ready
    public void deleteVandalism(Long vandalismId) {
        boolean exists =  vandalismRepository.existsById(vandalismId);
        if (!exists){
            throw new IllegalStateException(String.format("vandalism with id %d does not exist",vandalismId));
        }
        else {
            vandalismRepository.deleteById(vandalismId);
        }
    }
    //Todo add votes

    @Transactional
    public void updateVandalism(Long vandalismId,
                                Double lat,
                                Double lon,
                                String address,
                                String type,
                                String object,
                                Long votes,
                                Boolean cleaned){
        Vandalism vandalism = vandalismRepository.findById(vandalismId)
                .orElseThrow(()-> new IllegalStateException(String.format(
                        "vandalism with id %d does not exist",vandalismId)));
        if (address!=null && address.length()>0&&!address.equals(vandalism.getAddress())){
            vandalism.setAddress(address);
        }

        if (lat!=null){

            Optional<Vandalism> vandalismOptional = vandalismRepository.findVandalismByLatLon(lat,vandalism.getLon());
            if (vandalismOptional.isPresent()){
                throw new IllegalStateException("coords already taken");
            }
            else {
                vandalism.setLat(lat);

            }

        }
        if (lon!=null){

            Optional<Vandalism> vandalismOptional = vandalismRepository.findVandalismByLatLon(lon,vandalism.getLon());
            if (vandalismOptional.isPresent()){
                throw new IllegalStateException("coords already taken");
            }
            else {
                vandalism.setLat(lon);

            }

        }


        if (type!=null && type.length()>0&&!type.equals(vandalism.getType())){
        vandalism.setType(type);
        }
        if (object!=null && object.length()>0&&!object.equals(vandalism.getObject())){
        vandalism.setObject(object);
        }
        if(cleaned!=null&&!cleaned.equals(vandalism.getCleaned())){
            vandalism.setCleaned(cleaned);
        }
        if (votes!=null&&!votes.equals(vandalism.getVotes())){
            vandalism.setVotes(votes);
        }

    }
}

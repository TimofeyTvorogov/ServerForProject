package com.example.demo.vandalism;

import javax.persistence.*;



@Entity
@Table
public class Vandalism {
    @Id
    @SequenceGenerator(
            name ="vandalism_sequence",
            sequenceName = "vandalism_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vandalism_generator"
    )
    private Long id;
    private Double lat;
    private Double lon;
    private String address;
    private String type;
    private String object;
    private Long votes;

    private String imageName;
    private Boolean cleaned;


    public Vandalism(Long id,
                     Double lat,
                     Double lon,
                     String address,
                     String type,
                     String object,
                     Long votes,
                     String imageName,
                     Boolean cleaned) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
        this.type = type;
        this.object = object;
        this.votes = votes;
        this.imageName = imageName;
        this.cleaned = cleaned;
    }


    public Vandalism(Double lat,
                     Double lon,
                     String address,
                     String type,
                     String object,
                     Long votes,
                     String imageName,
                     Boolean cleaned) {
        this.lat = lat;
        this.lon = lon;
        this.address = address;
        this.type = type;
        this.object = object;
        this.votes = votes;
        this.imageName = imageName;
        this.cleaned = cleaned;

    }
    public Vandalism(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public Boolean getCleaned(){return cleaned;}
    public void setCleaned(Boolean cleaned){this.cleaned = cleaned;}
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}



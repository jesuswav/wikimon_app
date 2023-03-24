package com.example.wikimon_app;

import java.util.ArrayList;

public class Pokemones {

    String name;
    String image;
    String weigth;
    String heigth;
    String category;
    String element;
    String evolution_one;
    String getEvolution_two;
    String pokeball_type;
    String description;

    public Pokemones(String name, String image, String weigth, String heigth, String category, String element,
                     String evolution_one, String getEvolution_two, String pokeball_type, String description) {
        this.name = name;
        this.image = image;
        this.weigth = weigth;
        this.heigth = heigth;
        this.category = category;
        this.element = element;
        this.evolution_one = evolution_one;
        this.getEvolution_two = getEvolution_two;
        this.pokeball_type = pokeball_type;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public String getHeigth() {
        return heigth;
    }

    public void setHeigth(String heigth) {
        this.heigth = heigth;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getEvolution_one() {
        return evolution_one;
    }

    public void setEvolution_one(String evolution_one) {
        this.evolution_one = evolution_one;
    }

    public String getGetEvolution_two() {
        return getEvolution_two;
    }

    public void setGetEvolution_two(String getEvolution_two) {
        this.getEvolution_two = getEvolution_two;
    }

    public String getPokeball_type() {
        return pokeball_type;
    }

    public void setPokeball_type(String pokeball_type) {
        this.pokeball_type = pokeball_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

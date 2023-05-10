package com.acapa.ecoturismo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AttractivesDTOApp {
    private long id;
    @NotEmpty
    @Size(min = 3, message = "El nombre del atractivo debe de tener almenos 3 letras")
    private String nameAttractive;
    private String descriptionAttractive;
    private boolean featured;
    private TypesAttractivesDTOUse typesAttractives;
    private PruebaDTOApp prueba;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameAttractive() {
        return nameAttractive;
    }

    public void setNameAttractive(String nameAttractive) {
        this.nameAttractive = nameAttractive;
    }

    public String getDescriptionAttractive() {
        return descriptionAttractive;
    }

    public void setDescriptionAttractive(String descriptionAttractive) {
        this.descriptionAttractive = descriptionAttractive;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public TypesAttractivesDTOUse getTypesAttractives() {
        return typesAttractives;
    }

    public void setTypesAttractives(TypesAttractivesDTOUse typesAttractives) {
        this.typesAttractives = typesAttractives;
    }

    public PruebaDTOApp getPrueba() {
        return prueba;
    }

    public void setPrueba(PruebaDTOApp prueba) {
        this.prueba = prueba;
    }

    public AttractivesDTOApp() {
        super();
    }

}

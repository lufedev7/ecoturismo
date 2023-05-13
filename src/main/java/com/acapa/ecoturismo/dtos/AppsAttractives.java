package com.acapa.ecoturismo.dtos;

public class AppsAttractives {

    private long id;
    private String nameAttractive;
    private String descriptionAttractive;
    private boolean featured;

    private appPruebaDTO prueba;

    public appPruebaDTO getPrueba() {
        return prueba;
    }

    public void setPrueba(appPruebaDTO prueba) {
        this.prueba = prueba;
    }

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

    public AppsAttractives() {
        super();
    }

}

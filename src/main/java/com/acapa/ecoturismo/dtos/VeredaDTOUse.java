package com.acapa.ecoturismo.dtos;




public class VeredaDTOUse {
    private long id;
    private String veredaName;
    private long HabiNumVereda;
    private String CoorVereda;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVeredaName() {
        return veredaName;
    }

    public void setVeredaName(String veredaName) {
        this.veredaName = veredaName;
    }

    public long getHabiNumVereda() {
        return HabiNumVereda;
    }

    public void setHabiNumVereda(long habiNumVereda) {
        HabiNumVereda = habiNumVereda;
    }

    public String getCoorVereda() {
        return CoorVereda;
    }

    public void setCoorVereda(String coorVereda) {
        CoorVereda = coorVereda;
    }


    public VeredaDTOUse() {
    super();
    }





}

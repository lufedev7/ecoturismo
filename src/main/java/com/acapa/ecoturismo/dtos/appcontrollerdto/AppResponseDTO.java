package com.acapa.ecoturismo.dtos.appcontrollerdto;

import java.util.List;

import com.acapa.ecoturismo.dtos.ResourcesAttractivesDTO;
import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;

public class AppResponseDTO {
    private List<ResourcesServicesDTO> resourceServices;
    private List<ResourcesAttractivesDTO> resourceAttractives;

    private int numPageServices;
    private int sizePageServices;
    private long totalElementServices;
    private int totalPageServices;
    private boolean lateastServices;
    private int numPageAttractives;
    private int sizePageAttractives;
    private long totalElementAttractives;
    private int totalPageAttractives;
    private boolean lateastAttractives;

    public int getNumPageServices() {
        return numPageServices;
    }

    public void setNumPageServices(int numPageServices) {
        this.numPageServices = numPageServices;
    }

    public int getSizePageServices() {
        return sizePageServices;
    }

    public void setSizePageServices(int sizePageServices) {
        this.sizePageServices = sizePageServices;
    }

    public long getTotalElementServices() {
        return totalElementServices;
    }

    public void setTotalElementServices(long totalElementServices) {
        this.totalElementServices = totalElementServices;
    }

    public int getTotalPageServices() {
        return totalPageServices;
    }

    public void setTotalPageServices(int totalPageServices) {
        this.totalPageServices = totalPageServices;
    }

    public boolean isLateastServices() {
        return lateastServices;
    }

    public void setLateastServices(boolean lateastServices) {
        this.lateastServices = lateastServices;
    }

    public int getNumPageAttractives() {
        return numPageAttractives;
    }

    public void setNumPageAttractives(int numPageAttractives) {
        this.numPageAttractives = numPageAttractives;
    }

    public int getSizePageAttractives() {
        return sizePageAttractives;
    }

    public void setSizePageAttractives(int sizePageAttractives) {
        this.sizePageAttractives = sizePageAttractives;
    }

    public long getTotalElementAttractives() {
        return totalElementAttractives;
    }

    public void setTotalElementAttractives(long totalElementAttractives) {
        this.totalElementAttractives = totalElementAttractives;
    }

    public int getTotalPageAttractives() {
        return totalPageAttractives;
    }

    public void setTotalPageAttractives(int totalPageAttractives) {
        this.totalPageAttractives = totalPageAttractives;
    }

    public boolean isLateastAttractives() {
        return lateastAttractives;
    }

    public void setLateastAttractives(boolean lateastAttractives) {
        this.lateastAttractives = lateastAttractives;
    }

    public AppResponseDTO() {
        super();
    }

    public List<ResourcesServicesDTO> getResourceServices() {
        return resourceServices;
    }

    public void setResourceServices(List<ResourcesServicesDTO> resourceServices) {
        this.resourceServices = resourceServices;
    }

    public List<ResourcesAttractivesDTO> getResourceAttractives() {
        return resourceAttractives;
    }

    public void setResourceAttractives(List<ResourcesAttractivesDTO> resourceAttractives) {
        this.resourceAttractives = resourceAttractives;
    }

}

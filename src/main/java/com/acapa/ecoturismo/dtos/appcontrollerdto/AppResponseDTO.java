package com.acapa.ecoturismo.dtos.appcontrollerdto;

import java.util.List;

import com.acapa.ecoturismo.dtos.ResourcesAttractivesDTO;
import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;

public class AppResponseDTO {
    private List<ResourcesServicesDTO> resourceServices;
    private List<ResourcesAttractivesDTO> resourceAttractives;
    private int numPage;
    private int sizePage;
    private long totalElement;
    private int totalPage;
    private boolean lateast;
    
    public int getNumPage() {
        return numPage;
    }
    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }
    public int getSizePage() {
        return sizePage;
    }
    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }
    public long getTotalElement() {
        return totalElement;
    }
    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public boolean isLateast() {
        return lateast;
    }
    public void setLateast(boolean lateast) {
        this.lateast = lateast;
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

package com.acapa.ecoturismo.dtos;

import java.util.List;

public class OrganizationsResponse {
    private List<OrganizationsDTO> content;
    private int numPage;
    private int sizePage;
    private long totalElement;
    private int totalPage;
    private boolean lateast;

    public List<OrganizationsDTO> getContent() {
        return content;
    }
    public void setContent(List<OrganizationsDTO> content) {
        this.content = content;
    }
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
    public OrganizationsResponse() {
        super();
    }
    
}

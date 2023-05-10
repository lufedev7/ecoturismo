package com.acapa.ecoturismo.controllers.appcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acapa.ecoturismo.dtos.ResourcesServicesDTO;
import com.acapa.ecoturismo.dtos.appcontrollerdto.AppResponseDTO;
import com.acapa.ecoturismo.services.appservices.AppServices;
import com.acapa.ecoturismo.utils.appConst;

@RestController
@RequestMapping("/api/appcontroller")
@CrossOrigin(origins = "http://localhost:3000")
public class AppController {
    @Autowired
    private AppServices appServices;

    @GetMapping
    public AppResponseDTO listAppController(

            @RequestParam(value = "nomPage", defaultValue = appConst.Mesure_Page_For_Default, required = false) int numberPage,

            @RequestParam(value = "pageSize", defaultValue = appConst.Number_Page_For_Default, required = false) int measure,

            @RequestParam(value = "sortBy", defaultValue = appConst.Order_By_For_Default, required = false) String orderBy,

            @RequestParam(value = "sortDir", defaultValue = appConst.Order_By_For_Dir, required = false) String sortDir) {
        return appServices.getpageFeed(numberPage, measure, orderBy, sortDir);
    }

    @GetMapping("/allservices")
    public List<ResourcesServicesDTO> listAllResourcesServicesByservices() {
        return appServices.getAllResourceServices();
    }
}

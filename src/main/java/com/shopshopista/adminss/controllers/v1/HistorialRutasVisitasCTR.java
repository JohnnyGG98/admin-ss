
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.HistorialRutasVisitas;
import com.shopshopista.adminss.repositorys.HistorialRutasVisitasRep;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HistorialRutasVisitasCTR {
    
    @Autowired
    private HistorialRutasVisitasRep histRutasVisitasRep;
    
    @GetMapping("/historialrutasvisitas")
    @CrossOrigin
    public List<HistorialRutasVisitas> getAllHistRutasVisitas(){
        return this.histRutasVisitasRep.findAll();
    }
    
    @RequestMapping(value = "/historialrutavisita", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public HistorialRutasVisitas createHistRutaVisita(HistorialRutasVisitas histRutaVisita){
        return this.histRutasVisitasRep.save(histRutaVisita);
    }
    
    @RequestMapping(value = "/eliminarhistorialrutavisita/{idHistRutaVisita}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void elminar_Hist_Ruta_Visita(Long idHistRutaVisita){
        this.histRutasVisitasRep.eliminarByIdHisRutasVisitas(idHistRutaVisita);
    }
    
    @GetMapping("/historialrutasvisitas/{idHistRutaVisita}")
    @ResponseBody
    public HistorialRutasVisitas getHistRutaVisitaById(Long idHistRutaVisita){
        return this.histRutasVisitasRep.buscarPorIdHisRutaVisitas(idHistRutaVisita);
    }
    
}


package com.shopshopista.adminss.controllers.v1.historial;

import com.shopshopista.adminss.models.Admins.historial.HistorialRutasVisitas;
import com.shopshopista.adminss.repositorys.historial.HistorialRutasVisitasRep;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/historialrutasvisitas")
public class HistorialRutasVisitasCTR {
    
    @Autowired
    private HistorialRutasVisitasRep histRutasVisitasRep;
    
    @GetMapping("/")
    @CrossOrigin
    public List<HistorialRutasVisitas> getAllHistRutasVisitas(){
        return this.histRutasVisitasRep.findAll();
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public HistorialRutasVisitas createHistRutaVisita(@Valid @RequestBody HistorialRutasVisitas histRutaVisita){
        return this.histRutasVisitasRep.save(histRutaVisita);
    }
    
    @RequestMapping(value = "/eliminar/{idHistRutaVisita}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminar_Hist_Ruta_Visita(@PathVariable Long idHistRutaVisita){
        this.histRutasVisitasRep.eliminarByIdHisRutasVisitas(idHistRutaVisita);
    }
    
    @GetMapping("/{idHistRutaVisita}")
    @ResponseBody
    public HistorialRutasVisitas getHistRutaVisitaById(@PathVariable Long idHistRutaVisita){
        return this.histRutasVisitasRep.buscarPorIdHisRutaVisitas(idHistRutaVisita);
    }
    
}

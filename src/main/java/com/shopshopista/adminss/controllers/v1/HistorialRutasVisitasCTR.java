
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.HistorialRutasVisitas;
import com.shopshopista.adminss.repositorys.HistorialRutasVisitasRep;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class HistorialRutasVisitasCTR {
    
    @Autowired
    private HistorialRutasVisitasRep histRutasVisitasRep;
    
    @GetMapping("/historialrutasvisitas")
    @CrossOrigin
    public List<HistorialRutasVisitas> getAllHistRutasVisitas(){
        return this.histRutasVisitasRep.findAll();
    }
    
    @RequestMapping(value = "/guardarhistorialrutavisita", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public HistorialRutasVisitas createHistRutaVisita(@Valid HistorialRutasVisitas histRutaVisita){
        return this.histRutasVisitasRep.save(histRutaVisita);
    }
    
    @RequestMapping(value = "/eliminarhistorialrutavisita/{idHistRutaVisita}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminar_Hist_Ruta_Visita(@PathVariable Long idHistRutaVisita){
        this.histRutasVisitasRep.eliminarByIdHisRutasVisitas(idHistRutaVisita);
    }
    
    @GetMapping("/historialrutasvisitas/{idHistRutaVisita}")
    @ResponseBody
    public HistorialRutasVisitas getHistRutaVisitaById(@PathVariable Long idHistRutaVisita){
        return this.histRutasVisitasRep.buscarPorIdHisRutaVisitas(idHistRutaVisita);
    }
    
}

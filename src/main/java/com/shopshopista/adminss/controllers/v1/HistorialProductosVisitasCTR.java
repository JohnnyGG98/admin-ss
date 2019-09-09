
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.HistorialProductosVisitas;
import com.shopshopista.adminss.repositorys.HistorialProductosVisitasRep;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HistorialProductosVisitasCTR {
    
    @Autowired
    private HistorialProductosVisitasRep historialProductosVisitasRep;
    
    @GetMapping("/historialproductosvisitas")
    @CrossOrigin
    public List<HistorialProductosVisitas> getAllHistorialProduVisitas(){
        return this.historialProductosVisitasRep.findAll();
    }
    
    @RequestMapping(value = "/historialproductovisita", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public HistorialProductosVisitas createHistorialProductoVisita(HistorialProductosVisitas historialProductosVisitas){
        return this.historialProductosVisitasRep.save(historialProductosVisitas);
    }
    
    @RequestMapping(value = "/eliminarhistorialproductovisita/{idHistProductoVisita}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminar_Historial_Producto_Visita(@PathVariable Long idHistProductoVisita){
        this.historialProductosVisitasRep.eliminarByIdHisProductosVisita(idHistProductoVisita);
    }
    
    @GetMapping("/historialproductosvisitas/{idHistProductoVisita}")
    @ResponseBody
    public HistorialProductosVisitas getHistoProductoVisitaById(@PathVariable Long idHistProductoVisita){
        return this.historialProductosVisitasRep.buscarPorIdHisProductosVisita(idHistProductoVisita);
    }
    
}

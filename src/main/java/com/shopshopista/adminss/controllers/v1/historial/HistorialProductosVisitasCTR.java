package com.shopshopista.adminss.controllers.v1.historial;

import com.shopshopista.adminss.models.Admins.historial.HistorialProductosVisitas;
import com.shopshopista.adminss.repositorys.historial.HistorialProductosVisitasRep;
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
@RequestMapping("/api/v1/historial/producto/visitas")
@CrossOrigin("*")
public class HistorialProductosVisitasCTR {

    @Autowired
    private HistorialProductosVisitasRep historialProductosVisitasRep;

    @GetMapping("/")
    public List<HistorialProductosVisitas> getAllHistorialProduVisitas() {
        return this.historialProductosVisitasRep.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    public HistorialProductosVisitas createHistorialProductoVisita(@Valid @RequestBody HistorialProductosVisitas historialProductosVisitas) {
        return this.historialProductosVisitasRep.save(historialProductosVisitas);
    }

    @RequestMapping(value = "/eliminar/{idHistProductoVisita}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminar_Historial_Producto_Visita(@PathVariable Long idHistProductoVisita) {
        this.historialProductosVisitasRep.eliminarByIdHisProductosVisita(idHistProductoVisita);
    }

    @GetMapping("/{idHistProductoVisita}")
    @ResponseBody
    public HistorialProductosVisitas getHistoProductoVisitaById(@PathVariable Long idHistProductoVisita) {
        return this.historialProductosVisitasRep.buscarPorIdHisProductosVisita(idHistProductoVisita);
    }

}

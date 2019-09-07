
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.HistorialRutasAdmin;
import com.shopshopista.adminss.repositorys.HistorialRutasAdminRep;
import java.util.List;
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
@RequestMapping("/api/v1")
public class HistoriaRutasAdminCTR {
    
    @Autowired
    private HistorialRutasAdminRep hisRutasAdminRepositorio;
    
    @GetMapping("/historialrutasadmins")
    @CrossOrigin
    public List<HistorialRutasAdmin> getAllHistRutasAdmins(){
        return this.hisRutasAdminRepositorio.findAll();
    }
    
    @RequestMapping(value = "/historialrutasadmin", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public HistorialRutasAdmin createHistorialRutasAdmin(@RequestBody HistorialRutasAdmin histRutasAdmin) {
        return this.hisRutasAdminRepositorio.save(histRutasAdmin);
    }
    
    @RequestMapping(value = "/eliminarhistrutasadmin/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarHistRutasAdmin(@PathVariable Long id){
        this.hisRutasAdminRepositorio.eliminarByIdHistRuta(id);
    } 
    
    @GetMapping("/historialrutasadmins/{historialruta}")
    @ResponseBody
    public List<HistorialRutasAdmin> getHistRutasAdminByRuta(@PathVariable String historialRuta) {
        return this.hisRutasAdminRepositorio.buscarPorHistorialRuta(historialRuta);
    }
    
    @GetMapping("/historialrutasadmins/{id}")
    @ResponseBody
    public HistorialRutasAdmin getHistRutasAdminById(@PathVariable Long historialRutaAdminId) {
        return this.hisRutasAdminRepositorio.buscarPorHistorialRutaAdminById(historialRutaAdminId);
    }
}

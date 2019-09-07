
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.Rutas;
import com.shopshopista.adminss.repositorys.RutasRep;
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
public class RutasCTR {
    
    @Autowired
    private RutasRep rutasRepositorio;
    
    @GetMapping("/rutas")
    @CrossOrigin
    public List<Rutas> getAllRutas(){
        return this.rutasRepositorio.findAll();
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Rutas createRuta(Rutas ruta){
        return this.rutasRepositorio.save(ruta);
    }
    
    @RequestMapping(value = "/eliminarRuta/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void  eliminarRuta(Long idRuta){
        this.rutasRepositorio.eliminarByIdRuta(idRuta);
    }
    
    @GetMapping("/rutas/{urlruta}")
    @ResponseBody
    public List<Rutas> getRutasByUrl(String urlRuta){
        return this.rutasRepositorio.buscarPorUrlRuta(urlRuta);
    }
    
    @GetMapping("/rutas/{id}")
    @ResponseBody
    public Rutas getRutaById(Long idRuta){
        return this.rutasRepositorio.buscarPorIdRuta(idRuta);
    }
}

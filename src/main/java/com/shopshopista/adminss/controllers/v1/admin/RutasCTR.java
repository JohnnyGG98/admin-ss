package com.shopshopista.adminss.controllers.v1.admin;

import com.shopshopista.adminss.models.Admins.admin.Rutas;
import com.shopshopista.adminss.repositorys.admin.RutasRep;
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
@RequestMapping("/api/v1/rutas")
@CrossOrigin("*")
public class RutasCTR {

    @Autowired
    private RutasRep rutasRepositorio;

    @GetMapping("/")
    public List<Rutas> getAllRutas() {
        return this.rutasRepositorio.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    public Rutas createRuta(@Valid @RequestBody Rutas ruta) {
        return this.rutasRepositorio.save(ruta);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminarRuta(@PathVariable Long idRuta) {
        this.rutasRepositorio.eliminarByIdRuta(idRuta);
    }

    @RequestMapping(value = "/{urlruta}", method = RequestMethod.GET)
    @ResponseBody
    public List<Rutas> getRutasByUrl(@PathVariable String urlRuta) {
        return this.rutasRepositorio.buscarPorUrlRuta(urlRuta);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Rutas getRutaById(@PathVariable Long idRuta) {
        return this.rutasRepositorio.buscarPorIdRuta(idRuta);
    }
}

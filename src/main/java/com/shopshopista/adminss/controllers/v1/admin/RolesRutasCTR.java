package com.shopshopista.adminss.controllers.v1.admin;

import com.shopshopista.adminss.models.Admins.admin.RolesRutas;
import com.shopshopista.adminss.repositorys.admin.RolesRutasRep;
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
@RequestMapping("/api/v1/rol/rutas")
@CrossOrigin("*")
public class RolesRutasCTR {

    @Autowired
    private RolesRutasRep rolesRutasRep;

    @GetMapping("/")
    public List<RolesRutas> getAllRolesRutas() {
        return this.rolesRutasRep.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    public RolesRutas createRolRuta(@Valid @RequestBody RolesRutas rolRuta) {
        return this.rolesRutasRep.save(rolRuta);
    }

    @RequestMapping(value = "/eliminar/{idRol}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminarRolRuta(@PathVariable Long idRolRuta) {
        this.rolesRutasRep.eliminarByIdRolRuta(idRolRuta);
    }

    @GetMapping("/{idRolRuta}")
    @ResponseBody
    public RolesRutas getRolesRutaById(@PathVariable Long idRolRuta) {
        return this.rolesRutasRep.buscarPorIdRolRuta(idRolRuta);
    }

}

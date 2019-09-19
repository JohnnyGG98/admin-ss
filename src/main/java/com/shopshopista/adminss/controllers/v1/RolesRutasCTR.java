
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.RolesRutas;
import com.shopshopista.adminss.repositorys.RolesRutasRep;
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
@RequestMapping("/api/v1/admin")
public class RolesRutasCTR {
    
    @Autowired
    private RolesRutasRep rolesRutasRep;
    
    @GetMapping("/rolesrutas")
    @CrossOrigin
    public List<RolesRutas> getAllRolesRutas() {
        return this.rolesRutasRep.findAll();
    }

    @RequestMapping(value = "/guardarrolruta", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public RolesRutas createRolRuta(@Valid @RequestBody RolesRutas rolRuta) {
        return this.rolesRutasRep.save(rolRuta);
    }
    
    @RequestMapping(value = "/eliminarrolruta/{idRol}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarRolRuta(@PathVariable Long idRolRuta){
        this.rolesRutasRep.eliminarByIdRolRuta(idRolRuta);
    } 
    
    @GetMapping("/rolesrutas/{idRolRuta}")
    @ResponseBody
    public RolesRutas getRolesRutaById(@PathVariable Long idRolRuta) {
        return this.rolesRutasRep.buscarPorIdRolRuta(idRolRuta);
    }
    
}

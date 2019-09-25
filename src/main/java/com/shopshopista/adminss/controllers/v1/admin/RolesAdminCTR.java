
package com.shopshopista.adminss.controllers.v1.admin;

import com.shopshopista.adminss.models.Admins.admin.Admin;
import com.shopshopista.adminss.models.Admins.admin.RolesAdmin;
import com.shopshopista.adminss.repositorys.admin.RolesAdminRep;
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
@RequestMapping("/api/v1/rolesadmin")
public class RolesAdminCTR {
    
    @Autowired
    private RolesAdminRep rolesAdminRep;
    
    @GetMapping("/")
    @CrossOrigin
    public List<RolesAdmin> getAllRolesAdmin(){
        return this.rolesAdminRep.findAll();
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public RolesAdmin createRolAdmin(@Valid @RequestBody RolesAdmin rolAdmin){
        return this.rolesAdminRep.save(rolAdmin);
    }
    
    @RequestMapping(value = "/eliminar/{idRol}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarRolAdmin(@PathVariable Long idRolAdmin){
        this.rolesAdminRep.eliminarByIdRolAdmin(idRolAdmin);
    } 
    
    @GetMapping("/{nombreRolAdmin}")
    @ResponseBody
    public List<RolesAdmin> getRolesAdminByNombre(@PathVariable String nombreRolAdmin) {
        return this.rolesAdminRep.buscarPorNombreRolAdmin(nombreRolAdmin);
    }
    
    @GetMapping("/{idRolAdmin}")
    @ResponseBody
    public RolesAdmin getRolesAdminById(@PathVariable Long idRolAdmin) {
        return this.rolesAdminRep.buscarPorIdRolAdmin(idRolAdmin);
    }
}

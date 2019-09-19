
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.Admin;
import com.shopshopista.adminss.models.Admins.RolesAdmin;
import com.shopshopista.adminss.repositorys.RolesAdminRep;
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
public class RolesAdminCTR {
    
    @Autowired
    private RolesAdminRep rolesAdminRep;
    
    @GetMapping("/rolesadmin")
    @CrossOrigin
    public List<RolesAdmin> getAllRolesAdmin(){
        return this.rolesAdminRep.findAll();
    }
    
    @RequestMapping(value = "/guardarroladmin", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public RolesAdmin createRolAdmin(@Valid @RequestBody RolesAdmin rolAdmin){
        return this.rolesAdminRep.save(rolAdmin);
    }
    
    @RequestMapping(value = "/eliminarroladmin/{idRol}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarRolAdmin(@PathVariable Long idRolAdmin){
        this.rolesAdminRep.eliminarByIdRolAdmin(idRolAdmin);
    } 
    
    @GetMapping("/rolesadmin/{nombreRolAdmin}")
    @ResponseBody
    public List<RolesAdmin> getRolesAdminByNombre(@PathVariable String nombreRolAdmin) {
        return this.rolesAdminRep.buscarPorNombreRolAdmin(nombreRolAdmin);
    }
    
    @GetMapping("/rolesadmin/{idRolAdmin}")
    @ResponseBody
    public RolesAdmin getRolesAdminById(@PathVariable Long idRolAdmin) {
        return this.rolesAdminRep.buscarPorIdRolAdmin(idRolAdmin);
    }
}

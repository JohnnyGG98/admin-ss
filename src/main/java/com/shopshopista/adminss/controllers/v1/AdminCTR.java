
package com.shopshopista.adminss.controllers.v1;

import java.util.List;
import com.shopshopista.adminss.models.Admin;
import com.shopshopista.adminss.repositorys.AdminRep;
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
public class AdminCTR {
    
    @Autowired
    private AdminRep adminRepositorio;
    
    @GetMapping("/admins")
    @CrossOrigin
    public List<Admin> getAllAdmins() {
        return this.adminRepositorio.findAll();
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Admin createAdmin(@RequestBody Admin admin) {
        return this.adminRepositorio.save(admin);
    }
    
    @RequestMapping(value = "/elminar/[id]", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void elminarAdmin(@PathVariable Long id){
        this.adminRepositorio.eliminarById(id);
    } 

    @GetMapping("/admins/{nombre}")
    @ResponseBody
    public List<Admin> getAdminsByNombre(@PathVariable String nombre) {
        return this.adminRepositorio.buscarPorUsuario(nombre);
    }
}


package com.shopshopista.adminss.controllers.v1.admin;

import java.util.List;
import com.shopshopista.adminss.models.Admins.admin.Admin;
import com.shopshopista.adminss.repositorys.admin.AdminRep;
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
public class AdminCTR {
    
    @Autowired
    private AdminRep adminRepositorio;
    
    @GetMapping("/")
    @CrossOrigin
    public List<Admin> getAllAdmins() {
        return this.adminRepositorio.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Admin createAdmin(@RequestBody Admin admin) {
        return this.adminRepositorio.save(admin);
    }
    
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarAdmin(@PathVariable Long id){
        this.adminRepositorio.eliminarById(id);
    } 

    @GetMapping("/{nombre}")
    @ResponseBody
    public List<Admin> getAdminsByNombre(@PathVariable String nombre) {
        return this.adminRepositorio.buscarPorUsuario(nombre);
    }
}


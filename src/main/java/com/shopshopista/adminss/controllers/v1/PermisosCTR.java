
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.Permisos;
import com.shopshopista.adminss.repositorys.PermisoRep;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PermisosCTR {
    
    @Autowired
    private PermisoRep permisoRepositorio;
    
    @GetMapping("/permisos")
    @CrossOrigin
    public List<Permisos> getAllPermisos(){
        return this.permisoRepositorio.findAll();
    }
    
    @RequestMapping(value = "/permiso", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Permisos createPermiso(Permisos permiso){
        return this.permisoRepositorio.save(permiso);
    }
    
    @RequestMapping(value = "/eliminarPermiso/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarPermiso(@PathVariable Long idPermiso){
        this.permisoRepositorio.eliminarByIdPermiso(idPermiso);
    }
    
    @GetMapping("/permisos/{id}")
    @ResponseBody
    public Permisos buscaPermisoById(@PathVariable Long idPermiso){
        return this.permisoRepositorio.buscarPorIdPermiso(idPermiso);
    }
    
}

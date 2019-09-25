
package com.shopshopista.adminss.controllers.v1.admin;

import com.shopshopista.adminss.models.Admins.admin.Permisos;
import com.shopshopista.adminss.repositorys.admin.PermisoRep;
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
@RequestMapping("/api/v1/permisos")
public class PermisosCTR {
    
    @Autowired
    private PermisoRep permisoRepositorio;
    
    @GetMapping("/")
    @CrossOrigin
    public List<Permisos> getAllPermisos(){
        return this.permisoRepositorio.findAll();
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Permisos createPermiso(@Valid @RequestBody Permisos permiso){
        return this.permisoRepositorio.save(permiso);
    }
    
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
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

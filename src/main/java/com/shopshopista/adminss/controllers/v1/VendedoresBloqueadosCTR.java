
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.VendedoresBloqueados;
import com.shopshopista.adminss.repositorys.VendedoresBloqueadosRep;
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
public class VendedoresBloqueadosCTR {
    
    @Autowired
    private VendedoresBloqueadosRep vendedoresBloqRepositorio;
    
    @GetMapping("/vendedoresBloqueados")
    @CrossOrigin
    public List<VendedoresBloqueados> getAllVendedoresBloqueados(){
        return this.vendedoresBloqRepositorio.findAll();
    }
    
    @RequestMapping(value = "/vendedorbloqueado", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public VendedoresBloqueados createVendedorBloqueado(VendedoresBloqueados vendedorBloqueado){
        return this.vendedoresBloqRepositorio.save(vendedorBloqueado);
    }
    
    @RequestMapping(value = "/eliminarVendedorBloqueado/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarVendedorBloqueado(Long idVendedorBloqueado){
        this.vendedoresBloqRepositorio.eliminarByIdVenBloqueados(idVendedorBloqueado);
    }
    
    @GetMapping("/vendedorBloqueado/{id}")
    @ResponseBody
    public VendedoresBloqueados getVendedorBloqueadoById(Long idVendedorBloq){
        return this.getVendedorBloqueadoById(idVendedorBloq);
    }
    
}

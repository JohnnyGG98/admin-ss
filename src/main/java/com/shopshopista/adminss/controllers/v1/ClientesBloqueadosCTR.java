
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.ClientesBloqueados;
import com.shopshopista.adminss.repositorys.ClientesBloqueadosRep;
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
@RequestMapping("/api/v1/cliente/bloqueado")
public class ClientesBloqueadosCTR {
    
    @Autowired
    private ClientesBloqueadosRep clientesBloqRep;
    
    @GetMapping("/")
    @CrossOrigin
    public List<ClientesBloqueados> getAllClientesBloquados(){
        return this.clientesBloqRep.findAll();
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ClientesBloqueados createClienteBloqueado(@Valid @RequestBody ClientesBloqueados clienteBloq){
        return this.clientesBloqRep.save(clienteBloq);
    }
    
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void eliminarClienteBloqueado(@PathVariable Long idClienteBloqueado){
        this.clientesBloqRep.eliminarByIdCliBloqueados(idClienteBloqueado);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ClientesBloqueados getClienteBloqueadoById(@PathVariable Long idClienteBloqueado){
        return this.clientesBloqRep.buscarPorIdCliBloqueados(idClienteBloqueado);
    }
    
    
}

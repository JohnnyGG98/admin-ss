package com.shopshopista.adminss.controllers.v1.bloqueos;

import com.shopshopista.adminss.models.Admins.bloqueos.VendedoresBloqueados;
import com.shopshopista.adminss.repositorys.bloqueos.VendedoresBloqueadosRep;
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
@RequestMapping("/api/v1/vendedor/bloqueado")
@CrossOrigin("*")
public class VendedoresBloqueadosCTR {

    @Autowired
    private VendedoresBloqueadosRep vendedoresBloqRepositorio;

    @GetMapping("/")
    public List<VendedoresBloqueados> getAllVendedoresBloqueados() {
        return this.vendedoresBloqRepositorio.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    public VendedoresBloqueados createVendedorBloqueado(VendedoresBloqueados vendedorBloqueado) {
        return this.vendedoresBloqRepositorio.save(vendedorBloqueado);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void eliminarVendedorBloqueado(@PathVariable Long idVendedorBloqueado) {
        this.vendedoresBloqRepositorio.eliminarByIdVenBloqueados(idVendedorBloqueado);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VendedoresBloqueados getVendedorBloqueadoById(@PathVariable Long idVendedorBloq) {
        return this.getVendedorBloqueadoById(idVendedorBloq);
    }

}

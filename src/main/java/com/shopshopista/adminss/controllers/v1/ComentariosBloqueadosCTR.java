
package com.shopshopista.adminss.controllers.v1;

import com.shopshopista.adminss.models.Admins.ComentariosBloqueados;
import com.shopshopista.adminss.repositorys.ComentariosBloqueadosRep;
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
@RequestMapping("/api/v1/admin")
public class ComentariosBloqueadosCTR {
    
    @Autowired
    private ComentariosBloqueadosRep comentariosBloquRepositorio;
    
    @GetMapping("/comentariosbloqueados")
    @CrossOrigin
    public List<ComentariosBloqueados> getAllVendedoresBloq(){
        return this.comentariosBloquRepositorio.findAll();
    }
    
    @RequestMapping(value = "/comentariobloqueado", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ComentariosBloqueados createComentarioBloqueado(ComentariosBloqueados comentarioBloqueado){
        return this.comentariosBloquRepositorio.save(comentarioBloqueado);
    }
    
    @RequestMapping(value = "/eliminarcomentariobloqueado/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public void elminarComentarioBloqueado(@PathVariable Long idComentarioBloq){
        this.comentariosBloquRepositorio.eliminarByIdComeBloqueado(idComentarioBloq);
    }
    
    @GetMapping("/comentariosbloqueados/{id}")
    @ResponseBody
    public ComentariosBloqueados getComentarioBloquadoById(@PathVariable Long idComentarioBloq){
        return this.comentariosBloquRepositorio.buscarPorIdComeBloqueados(idComentarioBloq);
    }
    
}

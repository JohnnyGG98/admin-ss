package com.shopshopista.adminss.controllers.v1.bloqueos;

import com.shopshopista.adminss.models.Admins.bloqueos.ComentariosBloqueados;
import com.shopshopista.adminss.repositorys.bloqueos.ComentariosBloqueadosRep;
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
@RequestMapping("/api/v1/comentario/bloqueado")
@CrossOrigin("*")
public class ComentariosBloqueadosCTR {

    @Autowired
    private ComentariosBloqueadosRep comentariosBloquRepositorio;

    @GetMapping("/")
    public List<ComentariosBloqueados> getAllVendedoresBloq() {
        return this.comentariosBloquRepositorio.findAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    @ResponseBody
    public ComentariosBloqueados createComentarioBloqueado(@Valid @RequestBody ComentariosBloqueados comentarioBloqueado) {
        return this.comentariosBloquRepositorio.save(comentarioBloqueado);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void elminarComentarioBloqueado(@PathVariable Long idComentarioBloq) {
        this.comentariosBloquRepositorio.eliminarByIdComeBloqueado(idComentarioBloq);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ComentariosBloqueados getComentarioBloquadoById(@PathVariable Long idComentarioBloq) {
        return this.comentariosBloquRepositorio.buscarPorIdComeBloqueados(idComentarioBloq);
    }

}

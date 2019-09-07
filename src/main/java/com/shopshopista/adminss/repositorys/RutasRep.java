

package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.Rutas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RutasRep extends JpaRepository<Rutas, Long>  {
    
    @Query(value = "SELECT r FROM rutas r WHERE r.rut_url LIKE :%urlRuta%")
    List<Rutas> buscarPorUrlRuta(@Param("urlRuta") String urlRuta);
    
    @Query(value = "SELECT r FROM rutas r WHERE r.id_ruta = :idRuta")
    Rutas buscarPorIdRuta(@Param("idRuta") Long idRuta);
    
    @Query(value = "UPDATE rutas r SET r.rut_activo = false WHERE r.id_ruta = :idRuta")
    void eliminarByIdRuta(@Param("idRuta") Long idRuta);
    
}

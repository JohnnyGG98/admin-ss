package com.shopshopista.adminss.repositorys.admin;

import com.shopshopista.adminss.models.Admins.admin.Rutas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RutasRep extends JpaRepository<Rutas, Long> {

    @Query(value = "SELECT r FROM Rutas r WHERE r.rut_url LIKE %:urlRuta%")
    List<Rutas> buscarPorUrlRuta(@Param("urlRuta") String urlRuta);

    @Query(value = "SELECT r FROM Rutas r WHERE r.id_ruta = :idRuta")
    Rutas buscarPorIdRuta(@Param("idRuta") Long idRuta);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Rutas r SET r.rut_activo = false WHERE r.id_ruta = :idRuta")
    void eliminarByIdRuta(@Param("idRuta") Long idRuta);

}

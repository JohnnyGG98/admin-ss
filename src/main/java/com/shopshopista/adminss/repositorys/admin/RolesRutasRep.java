package com.shopshopista.adminss.repositorys.admin;

import com.shopshopista.adminss.models.Admins.admin.RolesRutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RolesRutasRep extends JpaRepository<RolesRutas, Long> {

    @Query(value = "SELECT rr FROM RolesRutas rr WHERE rr.id_rol_ruta = :idRolRuta")
    RolesRutas buscarPorIdRolRuta(@Param("idRolRuta") Long idRolRuta);

    @Transactional
    @Modifying
    @Query(value = "UPDATE RolesRutas rr SET rr.roru_activo = false WHERE rr.id_rol_ruta = :idRolRuta")
    void eliminarByIdRolRuta(@Param("idRolRuta") Long idRolRuta);
}

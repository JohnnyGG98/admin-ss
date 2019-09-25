
package com.shopshopista.adminss.repositorys.admin;

import com.shopshopista.adminss.models.Admins.admin.RolesRutas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRutasRep extends JpaRepository<RolesRutas, Long>{
    
    @Query(value = "SELECT rr FROM RolesRutas rr WHERE rr.id_rol_ruta = :idRolRuta")
    RolesRutas buscarPorIdRolRuta(@Param("idRolRuta") Long idRolRuta);
    
    @Query(value = "UPDATE RolesRutas rr SET rr.roru_activo = false WHERE rr.id_rol_ruta = :idRolRuta")
    void eliminarByIdRolRuta(@Param("idRolRuta") Long idRolRuta);
}


package com.shopshopista.adminss.repositorys.admin;

import com.shopshopista.adminss.models.Admins.admin.Permisos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRep extends JpaRepository<Permisos, Long>  {
    
    @Query(value = "SELECT p FROM Permisos p WHERE p.id_permiso = :idPermiso")
    Permisos buscarPorIdPermiso(@Param("idPermiso") Long idPermiso);
    
    @Query(value = "UPDATE Permisos p SET p.prem_activo = false WHERE p.id_permiso = :idPermiso")
    void eliminarByIdPermiso(@Param("idPermiso") Long idPermiso);
    
}

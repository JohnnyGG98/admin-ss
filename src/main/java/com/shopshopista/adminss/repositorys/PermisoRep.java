package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.Permisos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PermisoRep extends JpaRepository<Permisos, Long> {

    @Query(value = "SELECT p FROM Permisos p WHERE p.id_permiso = :idPermiso")
    Permisos buscarPorIdPermiso(@Param("idPermiso") Long idPermiso);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Permisos p SET p.prem_activo = false WHERE p.id_permiso = :idPermiso")
    void eliminarByIdPermiso(@Param("idPermiso") Long idPermiso);

}

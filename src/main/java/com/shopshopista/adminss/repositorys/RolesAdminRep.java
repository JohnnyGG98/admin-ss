package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.RolesAdmin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RolesAdminRep extends JpaRepository<RolesAdmin, Long> {

    @Query(value = "SELECT ra FROM RolesAdmin ra WHERE ra.id_rol_admin = :idRolAdmin")
    RolesAdmin buscarPorIdRolAdmin(@Param("idRolAdmin") Long idRolAdmin);

    @Query(value = "SELECT ra FROM RolesAdmin ra WHERE ra.rlad_nombre LIKE %:nombreRol%")
    List<RolesAdmin> buscarPorNombreRolAdmin(@Param("nombreRol") String nombreRol);

    @Transactional
    @Modifying
    @Query(value = "UPDATE RolesAdmin ra SET ra.rlad_activo = false WHERE ra.id_rol_admin = :idRolAdmin")
    void eliminarByIdRolAdmin(@Param("idRolAdmin") Long idRolAdmin);
}

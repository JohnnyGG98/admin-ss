package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.HistorialRutasAdmin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HistorialRutasAdminRep extends JpaRepository<HistorialRutasAdmin, Long> {

    @Query(value = "SELECT h FROM HistorialRutasAdmin h WHERE h.hiru_ruta LIKE %:historialRuta%")
    List<HistorialRutasAdmin> buscarPorHistorialRuta(@Param("historialRuta") String historialRuta);

    @Query(value = "SELECT h FROM HistorialRutasAdmin h WHERE h.id_historial_ruta_admin = :idHistorial")
    HistorialRutasAdmin buscarPorHistorialRutaAdminById(@Param("idHistorial") Long idHistorial);

    @Transactional
    @Modifying
    @Query(value = "UPDATE HistorialRutasAdmin h SET h.hiru_activo = false WHERE h.id_historial_ruta_admin = :idHistorialAdmin")
    void eliminarByIdHistRuta(@Param("idHistorialAdmin") Long idHistorialAdmin);

}

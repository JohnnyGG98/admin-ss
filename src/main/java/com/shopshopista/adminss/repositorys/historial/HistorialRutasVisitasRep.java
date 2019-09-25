package com.shopshopista.adminss.repositorys.historial;

import com.shopshopista.adminss.models.Admins.historial.HistorialRutasVisitas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRutasVisitasRep extends JpaRepository<HistorialRutasVisitas, Long> {

    @Query(value = "SELECT h FROM HistorialRutasVisitas h WHERE h.id_historial_ruta_visitas = :idHisRutaVisitas")
    HistorialRutasVisitas buscarPorIdHisRutaVisitas(@Param("idHisRutaVisitas") Long idHisRutaVisitas);

    @Query(value = "UPDATE HistorialRutasVisitas h SET h.hruv_activo = false WHERE h.id_historial_ruta_visitas = :idHisRutaVisita")
    void eliminarByIdHisRutasVisitas(@Param("idHisRutaVisita") Long idHisRutaVisita);

}

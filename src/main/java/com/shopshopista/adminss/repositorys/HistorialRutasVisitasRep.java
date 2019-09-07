package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.HistorialRutasVisitas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRutasVisitasRep extends JpaRepository<HistorialRutasVisitas, Long> {

    @Query(value = "SELECT h FROM historial_rutas_visitas h WHERE h.id_historial_ruta_visitas = :idHisRutaVisitas")
    HistorialRutasVisitas buscarPorIdHisRutaVisitas(@Param("idHisRutaVisitas") Long idHisRutaVisitas);

    @Query(value = "UPDATE historial_rutas_visitas h SET h.hruv_activo = false WHERE h.id_historial_ruta_visitas = :idHisRutaVisitas")
    void eliminarByIdHisRutasVisitas(@Param("idHisRutaVisitas") Long idHisRutaVisitas);

}

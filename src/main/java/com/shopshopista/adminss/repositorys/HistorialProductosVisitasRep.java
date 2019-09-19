package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.HistorialProductosVisitas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HistorialProductosVisitasRep extends JpaRepository<HistorialProductosVisitas, Long> {

    @Query(value = "SELECT h FROM HistorialProductosVisitas h WHERE h.id_historial_producto_visita = :idHisProductosVisita")
    HistorialProductosVisitas buscarPorIdHisProductosVisita(@Param("idHisProductosVisita") Long idHisProductosVisita);

    @Transactional
    @Modifying
    @Query(value = "UPDATE HistorialProductosVisitas h SET h.hprv_activo = false WHERE h.id_historial_producto_visita = :idHisProductosVisita")
    void eliminarByIdHisProductosVisita(@Param("idHisProductosVisita") Long idHisProductosVisita);

}


package com.shopshopista.adminss.repositorys.historial;

import com.shopshopista.adminss.models.Admins.historial.HistorialProductosVisitas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialProductosVisitasRep extends JpaRepository<HistorialProductosVisitas, Long>  {
    
    @Query(value = "SELECT h FROM HistorialProductosVisitas h WHERE h.id_historial_producto_visita = :idHisProductosVisita")
    HistorialProductosVisitas buscarPorIdHisProductosVisita(@Param("idHisProductosVisita") Long idHisProductosVisita);
    
    @Query(value = "UPDATE HistorialProductosVisitas h SET h.hprv_activo = false WHERE h.id_historial_producto_visita = :idHisProductosVisita")
    void eliminarByIdHisProductosVisita(@Param("idHisProductosVisita") Long idHisProductosVisita);
    
}

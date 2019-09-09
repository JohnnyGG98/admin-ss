
package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.VendedoresBloqueados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedoresBloqueadosRep extends JpaRepository<VendedoresBloqueados, Long>  {
    
    @Query(value = "SELECT v FROM VendedoresBloqueados v WHERE v.id_vendedor_bloqueado = :idVenBloqueado")
    List<VendedoresBloqueados> buscarPorIdVenBloqueados(@Param("idVenBloqueado") Long idVenBloqueado);
    
    @Query(value = "UPDATE VendedoresBloqueados v SET v.vebl_activo = false WHERE v.id_vendedor_bloqueado = :idVenBloqueado")
    void eliminarByIdVenBloqueados(@Param("idVenBloqueado") Long idVenBloqueado);
    
}

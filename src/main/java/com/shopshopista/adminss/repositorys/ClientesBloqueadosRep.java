
package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.ClientesBloqueados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesBloqueadosRep extends JpaRepository<ClientesBloqueados, Long>  {
    
    @Query(value = "SELECT c FROM clientes_bloqueados c WHERE c.id_cliente_bloqueado = :idCliBloqueado%")
    ClientesBloqueados buscarPorIdCliBloqueados(@Param("idCliBloqueado") Long idCliBloqueado);
    
    @Query(value = "UPDATE clientes_bloqueados c SET c.clbl_activo = false WHERE c.id_cliente_bloqueado = :idCliBloqueado")
    void eliminarByIdCliBloqueados(@Param("idCliBloqueado") Long idCliBloqueado);
    
}

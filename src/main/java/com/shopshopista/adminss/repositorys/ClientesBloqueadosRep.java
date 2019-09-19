package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.ClientesBloqueados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientesBloqueadosRep extends JpaRepository<ClientesBloqueados, Long> {

    @Query(value = "SELECT c FROM ClientesBloqueados c WHERE c.id_cliente_bloqueado = :idCliBloqueado")
    ClientesBloqueados buscarPorIdCliBloqueados(@Param("idCliBloqueado") Long idCliBloqueado);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ClientesBloqueados c SET c.clbl_activo = false WHERE c.id_cliente_bloqueado = :idCliBloqueado")
    void eliminarByIdCliBloqueados(@Param("idCliBloqueado") Long idCliBloqueado);

}

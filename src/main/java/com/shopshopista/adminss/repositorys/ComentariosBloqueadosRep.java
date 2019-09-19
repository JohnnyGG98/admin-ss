package com.shopshopista.adminss.repositorys;

import com.shopshopista.adminss.models.Admins.ComentariosBloqueados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ComentariosBloqueadosRep extends JpaRepository<ComentariosBloqueados, Long> {

    @Query(value = "SELECT c FROM ComentariosBloqueados c WHERE c.id_comentario_bloqueado = :idComeBloqueado")
    ComentariosBloqueados buscarPorIdComeBloqueados(@Param("idComeBloqueado") Long idComeBloqueado);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ComentariosBloqueados c SET c.cobl_activo = false WHERE c.id_comentario_bloqueado = :idComeBloqueado")
    void eliminarByIdComeBloqueado(@Param("idComeBloqueado") Long idComeBloqueado);

}

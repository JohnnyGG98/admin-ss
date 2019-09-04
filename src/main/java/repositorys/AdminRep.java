
package repositorys;

import java.util.List;
import models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRep extends JpaRepository<Admin, Long>{
    
    @Query(value = "SELECT e FROM Admins a WHERE a.adm_user LIKE %:nombre%")
    List<Admin> buscarPorUsuario(@Param("nombre") String nombre);
    
    @Query(value = "UPDATE Admins a SET a.adm_activo = false WHERE a.id_admin = :id")
    void eliminarById(@Param("id") Long id);
}

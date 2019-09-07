
package com.shopshopista.adminss.models.Productos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shopshopista.adminss.models.Admins.ComentariosBloqueados;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Comentarios")
public class Comentarios {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_comentario;
    
    @Column(name="comentario", nullable=false)
    private String comentario;
   
    @Column (name="com_activo", columnDefinition="BOOLEAN DEFAULT 'true'")
    private boolean com_activo;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "id_producto")
    private Productos producto;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comentarios")
    private List<ComentariosBloqueados> comentariosBloqueados;

    public Comentarios() {
    }

    public Comentarios(Long id_comentario, String comentario, boolean com_activo, Productos producto) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.com_activo = com_activo;
        this.producto = producto;
    }

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isCom_activo() {
        return com_activo;
    }

    public void setCom_activo(boolean com_activo) {
        this.com_activo = com_activo;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

//    public List<ComentariosBloqueados> getComentariosBloqueados() {
//        return comentariosBloqueados;
//    }
//
//    public void setComentariosBloqueados(List<ComentariosBloqueados> comentariosBloqueados) {
//        this.comentariosBloqueados = comentariosBloqueados;
//    }
    
    
}

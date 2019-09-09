
package com.shopshopista.adminss.models.Productos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shopshopista.adminss.models.Admins.HistorialProductosVisitas;
import java.time.LocalDateTime;
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
@Table(name="Productos")
public class Productos {
    
    //Falta Foránea
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_producto", nullable = false )
    private Long id_producto;
   
    @Column(name="prod_nombre", length = 255, nullable = false )
    private String prod_nombre;
    
    @Column(name="prod_fecha_Ingreso",columnDefinition = "timestamp DEFAULT now()") 
    private LocalDateTime prod_fecha_Ingreso;

    @Column(name="prod_stock_total", nullable=false )
    private int prod_stock_total;
    
    @Column(name="prod_marca", length=50)
    private String prod_marca;
    
    @Column(name="prod_precio_venta",nullable=false)
    private double prod_precio_venta;
    
    @Column(name="prod_descripcion",nullable=false)
    private String prod_descripcion;
    
    @Column(name="prod_restriccion_edad_max",nullable=false)
    private int prod_restriccion_edad_max;
    
    @Column(name="prod_restriccion_edad_min",nullable=false)
    private int prod_restriccion_edad_min;
    
    @Column(name="prod_activo", columnDefinition="BOOLEAN DEFAULT  'true' ")
    private boolean prod_activo;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marca")
    @JsonBackReference
    private Marcas marcas;
    
    //Falta la relación con el VENDEDOR
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productos")
    private List<HistorialProductosVisitas> hisProductosVisitas;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productos")
    private List<Comentarios> comentarios;
    

    public Productos() {
    }

    public Productos(Long id_producto, String prod_nombre, LocalDateTime prod_fecha_Ingreso, int prod_stock_total, String prod_marca, double prod_precio_venta, String prod_descripcion, int prod_restriccion_edad_max, int prod_restriccion_edad_min, boolean prod_activo, Marcas marca) {
        this.id_producto = id_producto;
        this.prod_nombre = prod_nombre;
        this.prod_fecha_Ingreso = prod_fecha_Ingreso;
        this.prod_stock_total = prod_stock_total;
        this.prod_marca = prod_marca;
        this.prod_precio_venta = prod_precio_venta;
        this.prod_descripcion = prod_descripcion;
        this.prod_restriccion_edad_max = prod_restriccion_edad_max;
        this.prod_restriccion_edad_min = prod_restriccion_edad_min;
        this.prod_activo = prod_activo;
        this.marcas = marca;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public LocalDateTime getProd_fecha_Ingreso() {
        return prod_fecha_Ingreso;
    }

    public void setProd_fecha_Ingreso(LocalDateTime prod_fecha_Ingreso) {
        this.prod_fecha_Ingreso = prod_fecha_Ingreso;
    }

    public int getProd_stock_total() {
        return prod_stock_total;
    }

    public void setProd_stock_total(int prod_stock_total) {
        this.prod_stock_total = prod_stock_total;
    }

    public String getProd_marca() {
        return prod_marca;
    }

    public void setProd_marca(String prod_marca) {
        this.prod_marca = prod_marca;
    }

    public double getProd_precio_venta() {
        return prod_precio_venta;
    }

    public void setProd_precio_venta(double prod_precio_venta) {
        this.prod_precio_venta = prod_precio_venta;
    }

    public String getProd_descripcion() {
        return prod_descripcion;
    }

    public void setProd_descripcion(String prod_descripcion) {
        this.prod_descripcion = prod_descripcion;
    }

    public int getProd_restriccion_edad_max() {
        return prod_restriccion_edad_max;
    }

    public void setProd_restriccion_edad_max(int prod_restriccion_edad_max) {
        this.prod_restriccion_edad_max = prod_restriccion_edad_max;
    }

    public int getProd_restriccion_edad_min() {
        return prod_restriccion_edad_min;
    }

    public void setProd_restriccion_edad_min(int prod_restriccion_edad_min) {
        this.prod_restriccion_edad_min = prod_restriccion_edad_min;
    }

    public boolean isProd_activo() {
        return prod_activo;
    }

    public void setProd_activo(boolean prod_activo) {
        this.prod_activo = prod_activo;
    }

    public Marcas getMarca() {
        return marcas;
    }

    public void setMarca(Marcas marca) {
        this.marcas = marca;
    }

    public List<HistorialProductosVisitas> getHisProductosVisitas() {
        return hisProductosVisitas;
    }

    public void setHisProductosVisitas(List<HistorialProductosVisitas> hisProductosVisitas) {
        this.hisProductosVisitas = hisProductosVisitas;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }
    
    
}

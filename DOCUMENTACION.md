## Documentacion de Admin - SS

#### Error
**09/09/2019**

Solucionamos el error al ingresar un admin, porque teniamos multiples referencias y debemos nombrar a cada referencia con su nombre para que sepa cual juntar con cual.
```java
  // Se agregoe el atributo value
  // (value = "nombre-referencia")

  // Clase Admin
  @JsonManagedReference(value = "admin-hr")
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
  private List<HistorialRutasAdmin> histRutasAdmin;

  @JsonManagedReference(value = "admin-permiso")
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
  private List<Permisos> permiso;

  //Clase Permiso
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_admin")
  @JsonBackReference(value = "admin-permiso")
  private Admin admin;

  //Clase historial rutas  
  @JsonBackReference(value = "admin-hr")
  @JoinColumn(name = "id_admin",referencedColumnName = "id_admin")
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Admin admin;

```

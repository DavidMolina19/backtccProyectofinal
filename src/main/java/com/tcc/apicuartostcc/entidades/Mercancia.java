package com.tcc.apicuartostcc.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mercancias")
public class Mercancia implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column  (name= "iup")
    private Integer iup;

    @Column  (name= "volumen")
    private Double volumen;
    @Column  (name= "nombre")
    private String nombre;

    @Column  (name= "tipo_remitente")
    private String tipoRemitente;
    @Column  (name= "id_remitente")
    private String idRemitente;
    @Column  (name= "nombre_remitente")
    private String nombreRemitente;
    @Column  (name= "departamento_remitente")
    private String departamentoRemitente;
    @Column  (name= "municipio_remitente")
    private String municipioRemitente;
    @Column  (name= "direccion_remitente")
    private String direccionRemitente;


    @Column  (name= "tipo_destinatario")
    private String tipoDestinatario;
    @Column  (name= "id_destinatario")
    private String idDestinatario;
    @Column  (name= "nombre_destinatario")
    private String nombreDestinatario;
    @Column  (name= "departamento_destinatario")
    private String departamentoDestinatario;

    @Column  (name= "municipio_destinatario")
    private String municipioDestinatario;
    @Column  (name= "direccion_destinatario")
    private String direccionDestinatario;

    @ManyToOne(optional = false)
    @JoinColumn(name ="fk_zona",referencedColumnName = "id")
    @JsonBackReference
    private Zona zona;


    public Mercancia() {
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Integer getIup() {
        return iup;
    }

    public void setIup(Integer iup) {
        this.iup = iup;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoRemitente() {
        return tipoRemitente;
    }

    public void setTipoRemitente(String tipoRemitente) {
        this.tipoRemitente = tipoRemitente;
    }

    public String getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(String idRemitente) {
        this.idRemitente = idRemitente;
    }

    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    public String getDepartamentoRemitente() {
        return departamentoRemitente;
    }

    public void setDepartamentoRemitente(String departamentoRemitente) {
        this.departamentoRemitente = departamentoRemitente;
    }

    public String getMunicipioRemitente() {
        return municipioRemitente;
    }

    public void setMunicipioRemitente(String municipioRemitente) {
        this.municipioRemitente = municipioRemitente;
    }

    public String getDireccionRemitente() {
        return direccionRemitente;
    }

    public void setDireccionRemitente(String direccionRemitente) {
        this.direccionRemitente = direccionRemitente;
    }

    public String getTipoDestinatario() {
        return tipoDestinatario;
    }

    public void setTipoDestinatario(String tipoDestinatario) {
        this.tipoDestinatario = tipoDestinatario;
    }

    public String getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(String idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getDepartamentoDestinatario() {
        return departamentoDestinatario;
    }

    public void setDepartamentoDestinatario(String departamentoDestinatario) {
        this.departamentoDestinatario = departamentoDestinatario;
    }

    public String getMunicipioDestinatario() {
        return municipioDestinatario;
    }

    public void setMunicipioDestinatario(String municipioDestinatario) {
        this.municipioDestinatario = municipioDestinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }
}

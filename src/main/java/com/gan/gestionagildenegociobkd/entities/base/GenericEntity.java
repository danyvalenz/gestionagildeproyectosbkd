package com.gan.gestionagildenegociobkd.entities.base;

import com.gan.gestionagildenegociobkd.entities.enums.TipoOperacionAuditoria;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class GenericEntity {

    @Comment("Fecha y hora que ejecuta la operación")
    @Column(name = "AUD_FECHA_HORA")
    protected LocalDateTime AuditoriafechaHora; //99 010101

    @Comment("Identificador único(código) del usuario que ejecuta la operación")
    @Column(name = "AUD_USUARIO_ID")
    protected Long AuditoriaUsuarioId;

    @Comment("Número de IP o nombre del equipo que ejecuta la operación")
    @Column(name = "AUD_IP_HOST_SESSION")
    protected String AuditoriaIpHostSesion;

    @Comment("Tipo de auditoria (1: Registro, 2:Actualización y 3 Eliminación)")
    @Column(name = "AUD_TIPO_OPERACION")
    protected TipoOperacionAuditoria auditoriaTipoOreacion;

    @Column(name = "estatus")
    @Comment("Estado de registro (1: Activo, 0: Inactivo (borrado lógico))")
    private Short estatus;

    public LocalDateTime getAuditoriafechaHora() {
        return AuditoriafechaHora;
    }

    public void setAuditoriafechaHora(LocalDateTime auditoriafechaHora) {
        AuditoriafechaHora = auditoriafechaHora;
    }

    public Long getAuditoriaUsuarioId() {
        return AuditoriaUsuarioId;
    }

    public void setAuditoriaUsuarioId(Long auditoriaUsuarioId) {
        AuditoriaUsuarioId = auditoriaUsuarioId;
    }

    public String getAuditoriaIpHostSesion() {
        return AuditoriaIpHostSesion;
    }

    public void setAuditoriaIpHostSesion(String auditoriaIpHostSesion) {
        AuditoriaIpHostSesion = auditoriaIpHostSesion;
    }

    public TipoOperacionAuditoria getAuditoriaTipoOreacion() {
        return auditoriaTipoOreacion;
    }

    public void setAuditoriaTipoOreacion(TipoOperacionAuditoria auditoriaTipoOreacion) {
        this.auditoriaTipoOreacion = auditoriaTipoOreacion;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }
}

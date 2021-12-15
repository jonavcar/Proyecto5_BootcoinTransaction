/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.bootcointransaction.utils;

/**
 *
 * @author jonavcar
 */
public enum Concept {

    PONER_DINERO("PONER-DINERO", "Poner dinero", MovementType.ABONO),
    MANDAR_DINERO("MANDAR-DINERO", "Mandar dinero", MovementType.CARGO),
    SACAR_DINERO("SACAR-DINERO", "Sacar dinero", MovementType.CARGO),
    PAGAR_SERVICIO("PAGAR-SERVICIO", "Pagar servicios", MovementType.CARGO),
    RECARGAR_CELULAR("RECARGAR-CELULAR", "Recargar celular", MovementType.CARGO),
    PAGAR_COMPRA("PAGAR-COMPRA", "Pagar compras en comercios", MovementType.CARGO);

    public final String value;
    public final String codigo;
    public final MovementType movementType;

    @Override
    public String toString() {
        return this.codigo;
    }

    public boolean equalsCodigo(String codigo) {
        return this.codigo.equals(codigo);
    }
    
    public MovementType getMovementType() {
        return this.movementType;
    }

    private Concept(String codigo, String value, MovementType movementType) {
        this.codigo = codigo;
        this.value = value;
        this.movementType = movementType;
    }
}

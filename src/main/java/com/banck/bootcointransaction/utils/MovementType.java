/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.bootcointransaction.utils;

/**
 *
 * @author jonavcar
 */
public enum MovementType {
    CARGO("CARGO"),
    ABONO("ABONO");

    public final String value;

    @Override
    public String toString() {
        return value;
    }

    public boolean equalsName(String otherValue) {
        return value.equals(otherValue);
    }

    private MovementType(String value) {
        this.value = value;
    }
}

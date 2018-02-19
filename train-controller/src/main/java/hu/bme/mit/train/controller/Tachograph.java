package hu.bme.mit.train.controller;


import com.google.*;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CompatibleWith;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by meres on 2/19/18.
 */
public class Tachograph implements Table{

    int currentTime;
    int joystickPos;
    int referenceSpeed;

    @Override
    public boolean contains(@NullableDecl @CompatibleWith("R") Object rowKey, @NullableDecl @CompatibleWith("C") Object columnKey) {
        return false;
    }

    @Override
    public boolean containsRow(@NullableDecl @CompatibleWith("R") Object rowKey) {
        return false;
    }

    @Override
    public boolean containsColumn(@NullableDecl @CompatibleWith("C") Object columnKey) {
        return false;
    }

    @Override
    public boolean containsValue(@NullableDecl @CompatibleWith("V") Object value) {
        return false;
    }

    @Override
    public Object get(@NullableDecl @CompatibleWith("R") Object rowKey, @NullableDecl @CompatibleWith("C") Object columnKey) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object put(Object rowKey, Object columnKey, Object value) {
        currentTime=(Integer)rowKey;
        joystickPos=(Integer)columnKey;
        referenceSpeed=(Integer)value;
        return null;
    }

    @Override
    public void putAll(Table table) {

    }

    @Override
    public Object remove(@NullableDecl @CompatibleWith("R") Object rowKey, @NullableDecl @CompatibleWith("C") Object columnKey) {
        return null;
    }

    @Override
    public Map row(Object rowKey) {
        return null;
    }

    @Override
    public Map column(Object columnKey) {
        return null;
    }

    @Override
    public Set<Cell> cellSet() {
        return null;
    }

    @Override
    public Set rowKeySet() {
        return null;
    }

    @Override
    public Set columnKeySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Map rowMap() {
        return null;
    }

    @Override
    public Map columnMap() {
        return null;
    }
}

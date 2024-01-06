package ue_4.s2210238039;

import kapitel_3.vl.IKey;

public class DataKey implements IKey {
    Object data;

    public DataKey(Object data) {
        this.data = data;
    }

    public boolean matches(Object data) {
        return this.data.equals(data);
    }
}


package Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProveraUtilTest {

    @Test
    void proveraRecTrue() {
        String rec = "Nikola";
        Assertions.assertEquals(true, ProveraUtil.proveraRec(rec));
    }

    @Test
    void proveraRecFalse() {
        String rec = "K1sN24S./,sl";
        Assertions.assertEquals(false, ProveraUtil.proveraRec(rec));
    }

    @Test
    void proveraRecPrazna() {
        String rec = "";
        Assertions.assertEquals(false, ProveraUtil.proveraRec(rec));

    }
}
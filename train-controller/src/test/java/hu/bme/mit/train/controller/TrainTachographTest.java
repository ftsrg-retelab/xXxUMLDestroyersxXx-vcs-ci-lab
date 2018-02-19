package hu.bme.mit.train.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TrainTachographTest {

    Tachograph tac;

    @Before
    public void before() {
        tac = new Tachograph();
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        tac.put(3, 3, 0);
        Assert.assertFalse(tac.isEmpty());

    }
}
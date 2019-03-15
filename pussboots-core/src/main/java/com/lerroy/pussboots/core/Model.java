/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.lerroy.pussboots.core;

/**
 *
 * @author chunhong.pch
 * @version $Id: Model.java, v 0.1 2018年11月06日 00:38 chunhong.pch Exp $
 */
public class Model implements Cloneable {
    private int    a;
    private String b;
    private Sub    c;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Sub getC() {
        return c;
    }

    public void setC(Sub c) {
        this.c = c;
    }

    protected Object clone() throws CloneNotSupportedException{
        Model model =(Model) super.clone();
        return model;
    }

    public static void main(String[] args) throws Exception{
        Model model = new Model();
        model.setA(1);
        model.setB("b");
        Sub c = new Sub();
        c.setC("c");
        model.setC(c);

        Model modelClone = (Model) model.clone();
    }
}

class Sub {
    private String c;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
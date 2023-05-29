package model;

import java.math.BigInteger;
import java.math.MathContext;

public class BigDecimal extends java.math.BigDecimal {
    public BigDecimal(char[] in, int offset, int len) {
        super(in, offset, len);
    }

    public BigDecimal(char[] in, int offset, int len, MathContext mc) {
        super(in, offset, len, mc);
    }

    public BigDecimal(char[] in) {
        super(in);
    }

    public BigDecimal(char[] in, MathContext mc) {
        super(in, mc);
    }

    public BigDecimal(String val) {
        super(val);
    }

    public BigDecimal(String val, MathContext mc) {
        super(val, mc);
    }

    public BigDecimal(double val) {
        super(val);
    }

    public BigDecimal(double val, MathContext mc) {
        super(val, mc);
    }

    public BigDecimal(BigInteger val) {
        super(val);
    }

    public BigDecimal(BigInteger val, MathContext mc) {
        super(val, mc);
    }

    public BigDecimal(BigInteger unscaledVal, int scale) {
        super(unscaledVal, scale);
    }

    public BigDecimal(BigInteger unscaledVal, int scale, MathContext mc) {
        super(unscaledVal, scale, mc);
    }

    public BigDecimal(int val) {
        super(val);
    }

    public BigDecimal(int val, MathContext mc) {
        super(val, mc);
    }

    public BigDecimal(long val) {
        super(val);
    }

    public BigDecimal(long val, MathContext mc) {
        super(val, mc);
    }
}

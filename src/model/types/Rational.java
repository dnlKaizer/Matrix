package model.types;

import model.Operable;

public class Rational implements Operable<Rational> {
    private int numerator;
    private int denominator;
    
    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Divisão por zero.");
        }
        int mdc = Math.abs(mdc(numerator, denominator));
        if (denominator < 0) {
            this.numerator = (-1) * numerator / mdc;
            this.denominator = (-1) * denominator / mdc;
        } else {
            this.numerator = numerator / mdc;
            this.denominator = denominator / mdc;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int mdc(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public boolean equalsOne() {
        return numerator == denominator;
    }

    @Override
    public boolean equalsZero() {
        return numerator == 0;
    }

    @Override
    public Rational sum(Rational value) {
        int numerator = this.numerator * value.getDenominator() + value.getNumerator() * this.denominator;
        int denominator = this.denominator * value.getDenominator();
        return new Rational(numerator, denominator);
    }

    @Override
    public Rational sub(Rational value) {
        int numerator = this.numerator * value.getDenominator() - value.getNumerator() * this.denominator;
        int denominator = this.denominator * value.getDenominator();
        return new Rational(numerator, denominator);
    }

    @Override
    public Rational mult(Rational value) {
        int numerator = this.numerator * value.getNumerator();
        int denominator = this.denominator * value.getDenominator();
        return new Rational(numerator, denominator);
    }

    @Override
    public Rational div(Rational value) {
        int numerator = this.numerator * value.getDenominator();
        int denominator = this.denominator * value.getNumerator();
        return new Rational(numerator, denominator);
    }

    @Override
    public Rational one() {
        return new Rational(1);
    }

    @Override
    public Rational zero() {
        return new Rational(0);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numerator);
        if (denominator != 1) stringBuilder.append("/").append(denominator);
        return stringBuilder.toString();
    }

}

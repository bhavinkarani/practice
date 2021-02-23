package com.leet.temp.Leet.jva;

import java.lang.reflect.Field;

public class FinalPrivateField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final A instance = new A( 10 , 20);
        System.out.println( instance.getField() );
        System.out.println( instance.getOther_field() );
        B.updateA( instance, 30 );
        System.out.println( instance.getField() );
        System.out.println( instance.getOther_field() );
    }

    public static class A
    {
        final int m_field;
        final int other_field;

        public A( final int field , int oth_field) {
            m_field = field;
            other_field = oth_field;
        }

        public int getField() {
            return m_field;
        }
        public int getOther_field(){
            return other_field;
        }
    }

    public static class B
    {
        public static void updateA( final A other, final int newValue ) throws NoSuchFieldException, IllegalAccessException
        {
            final Field fieldA = A.class.getDeclaredField( "m_field" );
            fieldA.setAccessible( true );
            fieldA.setInt( other, newValue );
            final Field fieldB = A.class.getDeclaredField( "other_field" );
            fieldA.setAccessible( true );
            fieldB.setInt(other, newValue);
        }
    }
}
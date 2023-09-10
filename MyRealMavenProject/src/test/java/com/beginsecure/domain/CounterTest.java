package com.beginsecure.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    private static final int ZERO = 0;
    private static final int FIFTY = 50;
    private static final int TWO_HUNDRED_THIRTY = 230;
    private static final int FOUR_HUNDRED_TWENTY_ONE = 421;
    private static final int TWO_THOUSAND = 2000;
    private static final int FIVE_THOUSAND = 5000;
    private static final int TEN_THOUSAND = 10000;
    private static final int TWENTY_THOUSAND = 20000;

    private Counter counter;

    @BeforeEach
    void setUp() {
        counter = new Counter();
    }
    @Test
    public void testConstructorWithValueOfZero(){
        assertEquals(0, counter.getValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {ZERO,FIFTY,TWO_HUNDRED_THIRTY,FOUR_HUNDRED_TWENTY_ONE
            ,TWO_THOUSAND,FIVE_THOUSAND,TEN_THOUSAND,TWO_THOUSAND,TWENTY_THOUSAND})
    public void testConstructorWithValidValues(int value){
        counter = new Counter(value);
        assertEquals(value,counter.getValue());
    }
    @ParameterizedTest
    @ValueSource(ints = {-FIFTY,-TWO_HUNDRED_THIRTY,-FOUR_HUNDRED_TWENTY_ONE
            ,-TWO_THOUSAND,-FIVE_THOUSAND,-TEN_THOUSAND,-TWO_THOUSAND,-TWENTY_THOUSAND})
    public void testConstructorWithInvalidValuesForConstructor(int value){
        try{
            new Counter(value);
            fail("IllegalArgumentException has not been thrown.");
        }catch(IllegalArgumentException e){
            // test passes
        }
    }
    @Test
    public void testIncreaseValueOnce(){
        counter.increaseValue();
        assertEquals(1,counter.getValue());
    }
    @Test
    public void testIncreaseValueFiveTimes(){
        for(int i = 0; i<5;i++){
            counter.increaseValue();
        }
        assertEquals(5,counter.getValue());
    }
    @Test
    public void testIncrementAtMaxIntValueMustThrowException(){
        counter = new Counter(Integer.MAX_VALUE);
        try{
            counter.increaseValue();
            fail("IllegalStateException has not been thrown.");
        }catch(IllegalStateException e){
            // test passes
        }
    }
    @Test
    public void testToStringProvidesCorrectResults(){
        String expectedString = "The value is 0";
        assertEquals(expectedString,counter.toString());
    }
}
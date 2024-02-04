package com.wwj.guava.utilites;

import com.google.common.base.Joiner;
import static org.hamcrest.MatcherAssert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JoinerTest {

    private final List<String> stringList = Arrays.asList("Google","Guava","Java","Scala","Kafka");

    private final List<String> stringListWithNullValue =  Arrays.asList("Google","Guava","Java","Scala",null);

    private final Map<String,String> stringMap = ImmutableMap.of("HELLO","Guava","Java","Scala");

    @Test
    public void testJoinOnJoin(){
        String result = Joiner.on("#").join(stringList);
        assertThat(result, equalTo("Google#Guava#Java#Scala#Kafka"));
    }

    @Test
    public void testJoinOnJoinWithNullValue(){
        Executable executable = () -> {
            String result = Joiner.on("#").join(stringListWithNullValue);
            assertThat(result, equalTo("Google#Guava#Java#Scala#Kafka"));
        };
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    public void testJoinOnJoinWithNullValueButSkip(){
        String result = Joiner.on("#").skipNulls().join(stringListWithNullValue);
        assertThat(result, equalTo("Google#Guava#Java#Scala"));
    }

    @Test
    public void testJoinOnJoinWithNullValueButUseDefaultValue(){
        String result = Joiner.on("#").useForNull("DEFAULT").join(stringListWithNullValue);
        assertThat(result, equalTo("Google#Guava#Java#Scala#DEFAULT"));
    }

    @Test
    public void testJoin_On_Append_To_StringBuilder(){

        final StringBuilder builder = new StringBuilder();
        StringBuilder resultBuilder = Joiner.on("#").useForNull("DEFAULT").appendTo(builder,stringListWithNullValue);
        assertThat(resultBuilder, sameInstance(builder));
        assertThat(resultBuilder.toString(),equalTo("Google#Guava#Java#Scala#DEFAULT"));
        assertThat(builder.toString(),equalTo("Google#Guava#Java#Scala#DEFAULT"));
    }

    @Test
    public void testJoinWithMap(){
        String result = Joiner.on("#").withKeyValueSeparator("=").join(stringMap);
        assertThat(result,equalTo("HELLO=Guava#Java=Scala"));
    }

}

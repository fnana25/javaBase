package com.wwj.guava.utilites;

import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;

public class SplitterTest {

    @Test
    public void testSplitOnSplit(){
        List<String> result = Splitter.on("|").splitToList("hello|world");
        assertThat(result,notNullValue());
        assertThat(result.size(),equalTo(2));
        assertThat(result.get(0),equalTo("hello"));
        assertThat(result.get(1),equalTo("world"));

    }
}

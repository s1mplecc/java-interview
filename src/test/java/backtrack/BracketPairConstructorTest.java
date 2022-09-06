package backtrack;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BracketPairConstructorTest {
    @Test
    public void should_construct_one_pair() {
        BracketPairConstructor constructor = new BracketPairConstructor();
        List<String> pairs = constructor.bracketPairs(1);
        assertThat(pairs).containsExactly("()");
    }

    @Test
    public void should_construct_two_pair() {
        BracketPairConstructor constructor = new BracketPairConstructor();
        List<String> pairs = constructor.bracketPairs(2);
        assertThat(pairs).containsExactlyInAnyOrder("()()", "(())");
    }

    @Test
    public void should_construct_three_pair() {
        BracketPairConstructor constructor = new BracketPairConstructor();
        List<String> pairs = constructor.bracketPairs(3);
        assertThat(pairs).containsExactlyInAnyOrder("((()))", "(()())", "(())()", "()(())", "()()()");
    }

    @Test
    public void should_construct_eight_pair() {
        BracketPairConstructor constructor = new BracketPairConstructor();
        List<String> pairs = constructor.bracketPairs(8);
        assertThat(pairs).contains("()()()()()()()()", "(())(())(())(())");
        assertThat(pairs).contains("(((((((())))))))", "(((())))(((())))");
    }
}
package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Bag01Test {
    @Test
    public void should_return_max_value_by_dp_when_case_1() {
        Bag01 bag = new Bag01();
        Bag01.Product[] products = {
                new Bag01.Product(1, 15),
                new Bag01.Product(3, 20),
                new Bag01.Product(4, 30)};

        int maxValue = bag.maxValue(4, products);
        assertThat(maxValue).isEqualTo(35);
        int maxValue2 = bag.maxValue(3, products);
        assertThat(maxValue2).isEqualTo(20);
        int maxValue3 = bag.maxValue(5, products);
        assertThat(maxValue3).isEqualTo(45);
        int maxValue4 = bag.maxValue(7, products);
        assertThat(maxValue4).isEqualTo(50);
        int maxValue5 = bag.maxValue(8, products);
        assertThat(maxValue5).isEqualTo(65);
    }
}
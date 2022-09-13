package dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Bag01Test {
    @Test
    public void should_return_max_value_by_2dim_dp() {
        Bag01 bag = new Bag01();
        Bag01.Product[] products = {
                new Bag01.Product(1, 15),
                new Bag01.Product(3, 20),
                new Bag01.Product(4, 30)};

        int maxValue = bag.maxValueBy2DimDP(4, products);
        assertThat(maxValue).isEqualTo(35);
        int maxValue2 = bag.maxValueBy2DimDP(3, products);
        assertThat(maxValue2).isEqualTo(20);
        int maxValue3 = bag.maxValueBy2DimDP(5, products);
        assertThat(maxValue3).isEqualTo(45);
        int maxValue4 = bag.maxValueBy2DimDP(7, products);
        assertThat(maxValue4).isEqualTo(50);
        int maxValue5 = bag.maxValueBy2DimDP(8, products);
        assertThat(maxValue5).isEqualTo(65);
    }

    @Test
    public void should_return_max_value_by_1dim_dp() {
        Bag01 bag = new Bag01();
        Bag01.Product[] products = {
                new Bag01.Product(1, 15),
                new Bag01.Product(3, 20),
                new Bag01.Product(4, 30)};

        int maxValue = bag.maxValueBy1DimDP(4, products);
        assertThat(maxValue).isEqualTo(35);
        int maxValue2 = bag.maxValueBy1DimDP(3, products);
        assertThat(maxValue2).isEqualTo(20);
        int maxValue3 = bag.maxValueBy1DimDP(5, products);
        assertThat(maxValue3).isEqualTo(45);
        int maxValue4 = bag.maxValueBy1DimDP(7, products);
        assertThat(maxValue4).isEqualTo(50);
        int maxValue5 = bag.maxValueBy1DimDP(8, products);
        assertThat(maxValue5).isEqualTo(65);
    }
}
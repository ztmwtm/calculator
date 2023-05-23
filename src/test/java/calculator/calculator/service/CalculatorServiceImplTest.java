package calculator.calculator.service;

import calculator.calculator.exception.ZeroArgumentException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class CalculatorServiceImplTest {
    CalculatorService calculatorService = new CalculatorServiceImpl();

    public static @NotNull Stream<Arguments> provideParamsForSumTest() {
        return Stream.of(
                Arguments.of("1", "1", 2),
                Arguments.of("2", "2", 4),
                Arguments.of("3", "3", 6),
                Arguments.of("99999", "99999", 199998)
        );
    }

    public static @NotNull Stream<Arguments> provideParamsForDiffTest() {
        return Stream.of(
                Arguments.of("1", "1", 0),
                Arguments.of("2", "2", 0),
                Arguments.of("3", "3", 0),
                Arguments.of("99999", "99999", 0),
                Arguments.of("99999", "99998", 1)
        );
    }

    public static @NotNull Stream<Arguments> provideParamsForMultiplyTest() {
        return Stream.of(
                Arguments.of("1", "1", 1),
                Arguments.of("2", "2", 4),
                Arguments.of("3", "3", 9),
                Arguments.of("9999", "9999", 99980001)
        );
    }

    public static @NotNull Stream<Arguments> provideParamsForDivTest() {
        return Stream.of(
                Arguments.of("1", "1", 1),
                Arguments.of("2", "2", 1),
                Arguments.of("3", "3", 1),
                Arguments.of("99999", "3", 33333)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSumTest")
    void sum(String first, String second, int result) {
        assertThat(calculatorService.sum(first, second)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDiffTest")
    void diff(String first, String second, int result) {
        assertThat(calculatorService.diff(first, second)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTest")
    void multiply(String first, String second, int result) {
        assertThat(calculatorService.multiply(first, second)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivTest")
    void div(String first, String second, int result) {
        assertThat(calculatorService.div(first, second)).isEqualTo(result);
    }

    @Test
    void divByZeroThenException() {
        assertThatThrownBy(() -> calculatorService.div("1", "0")).isInstanceOf(ZeroArgumentException.class);
    }
}
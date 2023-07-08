package com.ashdom.interview;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordCheckerTests {

	PasswordChecker passwordChecker;

	@BeforeEach
	void init() {
		passwordChecker = new PasswordChecker();
	}

	@ParameterizedTest
	@MethodSource
	void testForStrongPassword(String password, int steps) {
		Assertions.assertEquals(steps, passwordChecker.strongPasswordChecker(password));
	}

	private static Stream<Arguments> testForStrongPassword() {
		return Stream.of(Arguments.of("a", 5), Arguments.of("aA1", 3), Arguments.of("aaa123", 1),
				Arguments.of("1337C0d3", 0), Arguments.of("aaa111A", 2), Arguments.of("aaaaaa111A", 3), Arguments.of("aaa111", 2), Arguments.of("1111111111", 3),
				Arguments.of("ABABABABABABABABABAB1", 2), Arguments.of("bbaaaaaaaaaaaaaaacccccc", 8));
	}
}

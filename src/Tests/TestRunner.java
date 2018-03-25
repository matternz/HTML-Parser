package Tests;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import com.sun.org.apache.xalan.internal.xsltc.compiler.NodeTest;

/**
 * The test runner source: Dylan Chong
 */
public class TestRunner {

	/**
	 * List all classes to test here
	 */
	private static final Class<?>[] TEST_CLASSES = new Class[] { Node_Tests.class
			};

	public static void run() {
		System.out.println("Running tests in: ");
		for (Class<?> testClass : TEST_CLASSES) {
			System.out.println("- " + testClass.getSimpleName());
		}

		System.out.println();

		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.run(TEST_CLASSES);
	}
}
package com.laprasdrum.audioresearch;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.laprasdrum.audioresearch.helper.BookTestHelper.JUnitPracticeBook;
import static com.laprasdrum.audioresearch.matcher.IsDate.dateOf;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;
import static org.junit.matchers.JUnitMatchers.hasItems;

@RunWith(Enclosed.class)
//@RunWith(AndroidJUnit4.class)
public class Junit4SandboxTest {

    public static class SimpleTests {
        Calculator calculator;

        @Before
        public void setUp() throws Exception {
            calculator = new Calculator();
        }

        @After
        public void tearDown() throws Exception {
        }

        @Test(expected = IllegalArgumentException.class)
        public void testDivideByZero() {
            calculator.divide(12, 0);
        }

        @Test
        public void testShouldHaveHelloItem() {
            ArrayList<String> list = new ArrayList<>();

            list.add("Hello");
            list.add("World");

            assertThat(list, is(not(new ArrayList<String>())));
            assertThat(list, is(notNullValue()));
            assertThat(list, is(instanceOf(ArrayList.class)));

            ArrayList<String> copyList = list;
            assertThat(copyList, is(sameInstance(list)));

            String expected = "Hello";
            assertThat(list, hasItems(expected));

        }

        @Ignore
        @Test
        public void testShouldBeSameDateValue() {
            assertThat(new Date(), is(dateOf(2015, 2, 4)));
        }
    }

    public static class BookStoreTests {
        @Test
        public void testShouldLowerThan4000Yen() {
            Book junitBook = JUnitPracticeBook();
            assertThat(junitBook.price, is(lessThan(4000)));
        }
    }

    @RunWith(Theories.class)
    public static class ParameterTests {
        Calculator calculator;

        @Before
        public void setUp() throws Exception {
            calculator = new Calculator();
        }

        @DataPoints
        public static float[][] VALUES = {
                {3, 1, 3},
                {5, 2, (float) 2.5},
                {22, 11, 2},
        };

        @Theory
        public void divide(float[] values) {
            assertThat(calculator.divide(values[0], values[1]), is(values[2]));
        }

    }

    @RunWith(Theories.class)
    public static class CalculatorAddTest {
        Calculator calculator;

        @Before
        public void setUp() throws Exception {
            calculator = new Calculator();
        }

        @DataPoints
        public static Fixture[] PARAMS = {
                new Fixture(3, 4, 7),
                new Fixture(-2, 4, 2),
        };

        @Theory
        public void add(Fixture p) {
            assertThat(calculator.add(p.x, p.y), is(p.expected));
        }

        static class Fixture {
            int x;
            int y;
            int expected;

            Fixture(int x, int y, int expected) {
                this.x = x;
                this.y = y;
                this.expected = expected;
            }
        }
    }

    @RunWith(Theories.class)
    public static class MemberServiceTest {
        @DataPoints
        public static int[] AGES = {15, 20, 25, 30};
        @DataPoints
        public static Gender[] GENDERS = Gender.values();

        @Theory
        public void testIf25YoungerWomanThenTrue(int age, Gender gender) {
            assumeTrue(age <= 25 && gender == Gender.FEMALE);
            assertThat(Member.canEntry(age, gender), is(true));
        }

        @Theory
        public void testUnless25YoungerWomanThenFalse(int age, Gender gender) {
            assumeTrue(age > 25 || gender != Gender.FEMALE);
            String error = "When age=" + age + ", gender=" + gender;
            assertThat(error, Member.canEntry(age, gender), is(false));
        }
    }

    @RunWith(Enclosed.class)
    public static class RuleTests {

        @Ignore
        @RunWith(AndroidJUnit4.class)
        public static class TemporaryFolderTest extends ActivityInstrumentationTestCase2<MainActivity> {
            private MainActivity activity;

            public TemporaryFolderTest() {
                super(MainActivity.class);
            }

            @Rule
            public TemporaryFolder tempFolder = new TemporaryFolder();

            @Before
            public void setUp() throws Exception{
                super.setUp();
                injectInstrumentation(InstrumentationRegistry.getInstrumentation());
                activity = getActivity();
            }

            @Test
            public void testMake2Files() {
                File folder = tempFolder.getRoot();
                FileResource.mkFile(activity, 2, folder);
                String[] actualFiles = folder.list();
                Arrays.sort(actualFiles);

                assertThat(actualFiles.length, is(2));
                assertThat(actualFiles[0], is("UnitTest"));
                assertThat(actualFiles[1], is("readme.txt"));
            }

            @After
            public void tearDown() throws Exception {
                super.tearDown();
            }
        }

        @Ignore
        public static class ErrorCollectionTest {
            @Rule
            public ErrorCollector ec = new ErrorCollector();

            @Test
            public void testCalculation() {
                Calculator calculator = new Calculator();
                ec.checkThat(calculator.add(2, 3), is(5));
                ec.checkThat(calculator.add(2, 4), is(5));
                assertThat("show this message earlier than ErrorCollector verification", calculator.add(1, 1), is(0));
                ec.checkThat(calculator.add(2, 5), is(7));
            }
        }
    }

    public static class DateDependencyTest {
        @Test
        public void setCurrentTimeToDateWithDoSomething() {
            // slow test になると失敗する可能性のあるケース
//            DateDependencyExample sut = new DateDependencyExample();
//            sut.doSomething();
//            assertThat(sut.date, is(new Date()));

            // 依存関係を同一クラスの別メソッドに委譲して上書きするパターン
            final Date current = new Date();
            DateDependencyExample sut = new DateDependencyExample() {
                @Override
                protected Date newDate() {
                    return current;
                }
            };
            sut.doSomething();
            assertThat(sut.date, is(sameInstance(current)));
        }

        @Test
        public void setCurrentTimeToDateWithDoSomething2() {
            // 依存関係を別クラスにまとめて委譲して上書きするパターン
            final Date current = new Date();
            DelegateObjectBasedDateDependencyExample sut = new DelegateObjectBasedDateDependencyExample();
            sut.dataFactory = new DateFactory() {
                @Override
                public Date newDate() {
                    return current;
                }
            };
            sut.doSomething();
            assertThat(sut.date, is(CoreMatchers.sameInstance(current)));
        }

        @Test
        public void setCurrentTimeToDateWithDoSomething3() {
            // 依存関係を別インタフェースにまとめて委譲して上書きするパターン
            final Date current = new Date();
            DelegateInterfaceBasedDateDependencyExample sut = new DelegateInterfaceBasedDateDependencyExample();
            sut.dataFactory = new DateFactoryInterface() {
                @Override
                public Date newDate() {
                    return current;
                }
            };
            sut.doSomething();
            assertThat(sut.date, is(CoreMatchers.sameInstance(current)));
        }
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class A_FunctionChainJava6 {

    private interface MyFunc<T, R> {
        R execute(T t);
    }

    abstract class MyFuncAbstract<T, R> implements MyFunc<T, R> {

        <V> MyFunc<T,V> next(MyFunc<R, V> after) {
            return new MyFunc<T, V>() {
                @Override
                public V execute(T t) {
                    return after.execute(MyFuncAbstract.this.execute(t));
                }
            };
        }
    }

    @Test
    public void test() {
        MyFuncAbstract<String, String> append_1 = new MyFuncAbstract<>() {
            @Override
            public String execute(String s) {
                return s + " 1";
            }
        };

        MyFuncAbstract<String, String> append_3 = new MyFuncAbstract<>() {
            @Override
            public String execute(String s) {
                return s + " 2";
            }
        };

        // Chaining functions means a new function is made i.e. 3 functions exist!!
        // In other words a new function is needed to chain 2 functions!!
        MyFunc<String, String> chainedFunc = append_1.next(append_3);

        Assertions.assertEquals("manish 1 2", chainedFunc.execute("manish"));
    }
}
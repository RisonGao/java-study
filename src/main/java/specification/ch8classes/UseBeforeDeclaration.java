package specification.ch8classes;

/**
 * Usage: <b> Illegal forward reference </b>
 * Static fields whose declarations appear textually after the use is restricted:
 * If all meet, error:
 *  simple name
 *  appear in the right hand of assignment
 *  C is the innermost class or interface enclosing the use
 * @author Jingyi.Yang
 *         Date 2017/5/12
 **/
public class UseBeforeDeclaration {
    static {
        x = 100;
        // ok - assignment
        //int y = x + 1;
        // error - read before declaration
        int v = x = 3;
        // ok - x at left hand side of assignment
        int z = UseBeforeDeclaration.x * 2;
        // ok - not accessed via simple name

        Object o = new Object() {
            void foo() { x++; }
            // ok - occurs in a different class
            { x++; }
            // ok - occurs in a different class
        };
    }

    {
        j = 200;
        // ok - assignment
        //j = j + 1;
        // error - right hand side reads before declaration
        //int k = j = j + 1;
        // error - illegal forward reference to j
        int n = j = 300;
        // ok - j at left hand side of assignment
        //int h = j++;
        // error - read before declaration
        int l = this.j * 3;
        // ok - not accessed via simple name

        Object o = new Object() {
            void foo(){ j++; }
            // ok - occurs in a different class
            { j = j + 1; }
            // ok - occurs in a different class
        };
    }

    int w = x = 3;
    // ok - x at left hand side of assignment
    int p = x;
    // ok - instance initializers may access static fields

    static int u =
            (new Object() { int bar() { return x; } }).bar();
    // ok - occurs in a different class

    static int x;

    int m = j = 4;
    // ok - j at left hand side of assignment
    int o =
            (new Object() { int bar() { return j; } }).bar();
    // ok - occurs in a different class
    int j;
}

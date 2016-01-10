package app.proxy.dynamic;

import java.util.HashSet;
import java.util.Set;

import com.oozinoz.firework.Firecracker;
import com.oozinoz.firework.Sparkler;
import com.oozinoz.utility.Dollars;

/**
 * Show an example of using a dynamic proxy to add behavior to an object. In
 * this example, we add an element of impatience, complaining if any method
 * takes too long to execute.
 */
public class ShowDynamicProxy {
    public static void main(String[] args) {
        Set s = new HashSet();
        s = (Set) ImpatientProxy.newInstance(s);
        s.add(new Sparkler("Mr. Twinkle", new Dollars(0.05)));
        s.add(new BadApple("Lemon"));
        s.add(new Firecracker("Mr. Boomy", new Dollars(0.25)));

        System.out.println("The set contains " + s.size() + " things.");
    }
}

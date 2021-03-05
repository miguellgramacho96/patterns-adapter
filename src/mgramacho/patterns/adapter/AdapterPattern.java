package mgramacho.patterns.adapter;

import mgramacho.patterns.adapter.classes.RoundHole;
import mgramacho.patterns.adapter.classes.RoundPeg;
import mgramacho.patterns.adapter.classes.SquarePeg;
import mgramacho.patterns.adapter.classes.SquarePegAdapter;

/**
 * PROS
 * Open/Closed Principle. You can introduce new types of adapters into the program without breaking the existing client code.
 *
 * CONS
 * The overall complexity of the code increases because you need to introduce a set of new interfaces and classes.
 */
public class AdapterPattern {
    public static void main(String[] args) {
        // Round fits round, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);            // rounded peg which will make a perfect fit
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);   // too large square peg

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}

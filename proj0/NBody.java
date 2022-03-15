import java.io.File;

import static edu.princeton.cs.introcs.StdDraw.enableDoubleBuffering;


public class NBody {
    public static double readRadius(String S){
        In in = new In(S);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String S){
        In in = new In(S);
        int N = in.readInt();
        in.readDouble();
        Planet[] p = new Planet[N];
        for (int i = 0; i < p.length; i++) {
            p[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return p;
    }

    private static void drawBackground(double radius){
        StdDraw.setScale(-radius, radius);
        String imageToDraw = "images/starfield.jpg";

        /* Clears the drawing window. */
        StdDraw.clear();

        StdDraw.picture(0, 0, imageToDraw);

        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        //StdDraw.show();
        //StdDraw.pause(2000);
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet planets[] = readPlanets(filename);

        //enableDoubleBuffering();
        for (double current_time = 0; current_time <= T; current_time += dt) {
            double xForces[] = new double[planets.length];
            double yForces[] = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            drawBackground(radius);
            for (int i = 0; i < planets.length; i++) {
                planets[i].draw();
            }
            StdDraw.show(10);
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }


    }
}

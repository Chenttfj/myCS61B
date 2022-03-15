public class Planet {
        public double xxPos;
        public double yyPos;
        public double xxVel;
        public double yyVel;
        public double mass;
        public String imgFileName;
        private static final double G = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt((p.xxPos - this.xxPos) * (p.xxPos - this.xxPos) + (p.yyPos - this.yyPos) * (p.yyPos - this.yyPos));
    }

    public double calcForceExertedBy(Planet p){
        return G * this.mass * p.mass / ( calcDistance(p) * calcDistance(p) );
    }

    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet p[]){
        double X = 0;
        for (int i = 0; i < p.length; i++){
            if(!p[i].equals(this)){
                X += calcForceExertedByX(p[i]);
            }
        }
        return X;
    }

    public double calcNetForceExertedByY(Planet p[]){
        double Y = 0;
        for (int i = 0; i < p.length; i++){
            if(!p[i].equals(this)){
                Y += calcForceExertedByY(p[i]);
            }
        }
        return Y;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        xxVel += dt * aX;
        yyVel += dt * aY;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void  draw(){
        String imageToDraw = "images/" + this.imgFileName;

        /* Stamps three copies of advice.png in a triangular pattern. */
        StdDraw.picture(xxPos, yyPos, imageToDraw);

        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        //StdDraw.show();
        //StdDraw.pause(2000);
    }
}

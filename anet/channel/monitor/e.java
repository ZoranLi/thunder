package anet.channel.monitor;

/* compiled from: Taobao */
class e {
    private long a = 0;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i = 0.0d;
    private double j = 0.0d;
    private double k = 0.0d;

    e() {
    }

    public double a(double d, double d2) {
        e eVar = this;
        double d3 = d / d2;
        if (d3 >= 8.0d) {
            if (eVar.a == 0) {
                eVar.i = d3;
                eVar.h = eVar.i;
                eVar.d = eVar.h * 0.1d;
                eVar.c = eVar.h * 0.02d;
                eVar.e = (0.1d * eVar.h) * eVar.h;
            } else if (eVar.a == 1) {
                eVar.j = d3;
                eVar.h = eVar.j;
            } else {
                double d4 = d3 - eVar.j;
                eVar.i = eVar.j;
                eVar.j = d3;
                eVar.b = d3 / 0.95d;
                eVar.g = eVar.b - (eVar.h * 0.95d);
                Object obj = null;
                double sqrt = Math.sqrt(eVar.d);
                if (eVar.g >= 4.0d * sqrt) {
                    eVar.g = (0.75d * eVar.g) + (2.0d * sqrt);
                    obj = 1;
                } else if (eVar.g <= -4.0d * sqrt) {
                    eVar.g = (-1.0d * sqrt) + (0.75d * eVar.g);
                    obj = 2;
                }
                eVar.d = Math.min(Math.max(Math.abs((1.05d * eVar.d) - ((0.0025d * eVar.g) * eVar.g)), 0.8d * eVar.d), 1.25d * eVar.d);
                eVar.f = eVar.e / ((0.9025d * eVar.e) + eVar.d);
                eVar.h = (eVar.h + (1.0526315789473684d * d4)) + (eVar.f * eVar.g);
                if (obj == 1) {
                    eVar.h = Math.min(eVar.h, eVar.b);
                } else if (obj == 2) {
                    eVar.h = Math.max(eVar.h, eVar.b);
                }
                eVar.e = (1.0d - (0.95d * eVar.f)) * (eVar.e + eVar.c);
            }
            if (eVar.h < 0.0d) {
                eVar.k = eVar.j * 0.7d;
                eVar.h = eVar.k;
            } else {
                eVar.k = eVar.h;
            }
            return eVar.k;
        } else if (eVar.a != 0) {
            return eVar.k;
        } else {
            eVar.k = d3;
            return eVar.k;
        }
    }

    public void a() {
        this.a = 0;
        this.k = 0.0d;
    }
}

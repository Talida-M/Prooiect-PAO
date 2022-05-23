package models;

public enum Roluri {
    ADMIN(1),
    CLIENT(2),
    ARTIST(3);

    private int cod;
    Roluri(int cod) {
        this.cod = cod;
    }
    public static Roluri getByCode(int cod) {
        Roluri result = null;
        for(Roluri c : Roluri.values()) {
            if(c.cod == cod) {
                result = c;
            }
        }
        return result;
    }

    public static boolean compareTo(int o) {
        return ADMIN.compareTo(o);
    }
    public static boolean compareToArt(int o) {
        return ARTIST.compareTo(o);
    }
    public static boolean compareToC(int o) {
        return CLIENT.compareTo(o);
    }
}

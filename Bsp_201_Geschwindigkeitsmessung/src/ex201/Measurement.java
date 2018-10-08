package ex201;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Measurement implements Serializable {

    public LocalDate datum;
    public LocalTime uhrzeit;
    public String kennzeichen;
    public int vErl, vGem, ueberschreitung;

    public Measurement(LocalDate datum, LocalTime uhrzeit, String kennzeichen, int sErl, int sGem, int ueberschreitung) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.kennzeichen = kennzeichen;
        this.vErl = sErl;
        this.vGem = sGem;
        this.ueberschreitung = sGem - sErl;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getUhrzeit() {
        return uhrzeit;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public int getsErl() {
        return vErl;
    }

    public int getsGem() {
        return vGem;
    }

    public int getUeberschreitung() {
        return ueberschreitung;
    }
}

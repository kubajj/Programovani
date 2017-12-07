public class PoleIntu {
    public PoleIntu() {
    
    }
 
    // Přidá číslo na konec "pole"
    public void pridej(int a) {
        pole[pocet] = sc.nextInt();
        pocet++;
        if (pocet == pole.length) {
            pole = zvetsi(pole, pole.length * 2);
    }
 
    // Vrátí počet prvků v poli
    public int delka() {
      
    }
 
    // Řekne prvek na i-tém místě v poli
    public int prvek(int i) { ... }
}
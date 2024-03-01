
// Ali Eren KÖSE 01/03/2024 06:46

public class Main {
    public static void main(String[] args) {

        //Boksörlerin bilgilerini gir ve kaydet
        Fighter f1 = new Fighter("McGregor", 10, 120, 90, 20);
        Fighter f2 = new Fighter("Khabib", 15, 80, 85, 25);

        // eşleşmeyi belirle ve eşleşmeyi başlat
        Match match = new Match(f1, f2, 85, 100);
        match.run();
    }
}

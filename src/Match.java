import java.util.Random;

//match classını oluştur ve içeriğini tanımla
public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    int dodge;
    int firstPunch;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;

    }

    //yazı tura belirle
    public void coinFlip() {
        Random random = new Random();
        while (true) {
            System.out.println("Yazı Tura atılıyorr....");
            this.firstPunch = random.nextInt(1, 3);

            if (firstPunch == 1) {
                System.out.println("Tura geldi...");
                System.out.println("Karşılaşmaya McGregor başlıyor.!");
                break;
            } else if (firstPunch == 2) {
                System.out.println("Yazı geldi...");
                System.out.println("Karşılaşmaya Khabib Başlıyor.!");
            }
            break;
        }
    }

    // maçı başlat ve anlık bilgileri yazdır
    public void run() {

        if (isCheck()) {
            System.out.println("Boks Maçına Hoşgeldiniz !!");
            System.out.println("------------------------------");
            coinFlip();

            // tura gelirse f1 başlayacak
            if (firstPunch == 1) {
                while (this.f1.health > 0 && this.f2.health > 0) {
                    System.out.println("=========== YENİ ROUND ===========");
                    this.f2.health = this.f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                    System.out.println(this.f1.name + " Kalan canı " + f1.health);
                    System.out.println(this.f2.name + " Kalan canı " + f2.health);
                }
                // yazı gelirse ilk f2 başlayacak
            } else if (firstPunch == 2) {
                while (this.f1.health > 0 && this.f2.health > 0) {
                    System.out.println("=========== YENİ ROUND ===========");
                    this.f1.health = this.f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    System.out.println(this.f2.name + " Kalan canı " + f2.health);
                    System.out.println(this.f1.name + " Kalan canı " + f1.health);
                }

            }
            // sikletleri belirli aralıkta değilse uygunsuz yazdır
        } else {
            System.out.println("Sporcuların sikletleri eşit olmalıdır.");
        }
    }

    //f1 ve f2 ağrılıklarını siklete uygun olup olmadığının formülü
    boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    // canı sıfır ve altına inerse karşılaşmayı bitir isWin
    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " Kazandı..");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " Kazandı..");
            return true;
        }
        return false;
    }
}

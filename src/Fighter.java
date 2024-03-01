public class Fighter {

    //dövüşcülerin özelliklerini tanımla
    String name;
    int damage;
    int health;
    int weight;
    int dodge;

    // Constructor
    Fighter(String name, int damage, int health, int weight, int dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
    }

    // damage , dodge , eksilen sağlık yazdır belirle
    int hit(Fighter foe) {
        System.out.println(this.name + " =>" + foe.name + " " + this.damage + " hasar vurdu.");
        if (foe.isDodge()) {
            System.out.println(foe.name + " gelen hasarı blokladı!");
            return foe.health;
        }

        if (foe.health - this.damage < 0) {
            return 0;
        }
        return foe.health - this.damage;
    }

    // bloklama mekaniğini oluştur
    boolean isDodge() {
        double randomNumber = Math.random() * 100;
        return (randomNumber <= this.dodge);
    }
}

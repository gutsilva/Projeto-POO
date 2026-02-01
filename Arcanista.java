package classes;

public class Arcanista extends Combatente {
 private int mana = 100;
    public Arcanista(String nome, int nivel) { super(nome, nivel, 60); }
    @Override
    public String atacar(Combatente alvo) {
 if (mana >= 20) {
  mana -= 20;       int danoMistico = nivel * 10;
  alvo.defenderEReceberDano(danoMistico);
 return nome + " lançou feitiço (Dano: " + danoMistico + ")"; } else {
             mana += 40;
    alvo.defenderEReceberDano(nivel * 4);
    return nome + " usou ataque fraco e meditou.";
        }
    }
    @Override
    public void defenderEReceberDano(int danoBruto) {
      this.vida -= danoBruto; 
    }
}
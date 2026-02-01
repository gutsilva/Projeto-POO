package classes;
import java.util.Random;

public abstract class Combatente {
    protected String nome;
    protected int nivel;
    protected int vida;
    protected int vidaMaxima;
    protected Random random = new Random();
    public Combatente(String nome, int nivel, int vidaBase) {
      this.nome = nome;
  this.nivel = nivel;
      this.vida = vidaBase + (nivel * 20);
      this.vidaMaxima = this.vida;
    }
    public abstract String atacar(Combatente alvo);
    public abstract void defenderEReceberDano(int danoBruto);
    public boolean estaVivo() { return vida > 0; }
    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public void setVida(int v) { this.vida = Math.min(v, vidaMaxima); }
}
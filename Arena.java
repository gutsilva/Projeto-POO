package classes;

import java.util.*;

public class Arena {
 private List<Combatente> ladoA = new ArrayList<>();  private List<Combatente> ladoB = new ArrayList<>();
    public void adicionarLadoA(Combatente c) { ladoA.add(c); }
    public void adicionarLadoB(Combatente c) { ladoB.add(c); }
    public List<String> rodada() {
    List<String> logs = new ArrayList<>();
   List<Combatente> todos = new ArrayList<>();
 todos.addAll(ladoA);
    todos.addAll(ladoB); 
     Collections.shuffle(todos);
    for (Combatente atacante : todos) {     
      if (!atacante.estaVivo()) continue;
   List<Combatente> inimigos = ladoA.contains(atacante) ? ladoB : ladoA;   
     if (!inimigos.isEmpty()) {
 Combatente alvo = inimigos.get(new Random().nextInt(inimigos.size()));   
        logs.add(atacante.atacar(alvo));
 ladoA.removeIf(p -> !p.estaVivo());
    ladoB.removeIf(p -> !p.estaVivo());
    }
   }
    return logs;
    }
    public boolean acabou() {
     return ladoA.isEmpty() || ladoB.isEmpty();
    }
    public String getVencedor() {
       if (ladoA.isEmpty() && ladoB.isEmpty()) return "Empate (Destruição Total)";
      return ladoA.isEmpty() ? "Horda das Sombras (Lado B)" : "Aliança da Luz (Lado A)";
    }
    public String getStatusEquipeA() {
  StringBuilder sb = new StringBuilder();
        for (Combatente c : ladoA) {   
   sb.append(c.getNome().toUpperCase()).append(" [HP: ").append(c.getVida()).append("]\n");
        }
  return sb.toString();
    }
    public String getStatusEquipeB() {
StringBuilder sb = new StringBuilder();
 for (Combatente c : ladoB) {
  sb.append(c.getNome().toUpperCase()).append(" [HP: ").append(c.getVida()).append("]\n");
  }     return sb.toString();
    }
}
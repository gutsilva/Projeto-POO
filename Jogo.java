package classes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class Jogo extends JFrame {
    private Arena arena = new Arena();
    private JTextArea areaTexto = new JTextArea();
    private JTextArea statusLadoA = new JTextArea();
    private JTextArea statusLadoB = new JTextArea();
    private JButton btnAcao = new JButton("⚔️ INICIAR PRÓXIMA RODADA ⚔️");

    public Jogo() {
        setTitle("GRANDE TORNEIO POO - BATTLE SIMULATOR");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(20, 20, 20));

       
        areaTexto.setBackground(new Color(30, 30, 30));
        areaTexto.setForeground(Color.WHITE);
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaTexto.setEditable(false);
        JScrollPane scrollCentral = new JScrollPane(areaTexto);
        scrollCentral.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY), "LOG DE COMBATE", 
            TitledBorder.CENTER, TitledBorder.TOP, null, Color.GRAY));

       
        statusLadoA = configurarPainelStatus(Color.CYAN, "ALIANÇA DA LUZ (LADO A)");
        statusLadoB = configurarPainelStatus(Color.ORANGE, "HORDA DAS SOMBRAS (LADO B)");

     
        add(new JScrollPane(statusLadoA), BorderLayout.WEST);
        add(scrollCentral, BorderLayout.CENTER);
        add(new JScrollPane(statusLadoB), BorderLayout.EAST);

      
        btnAcao.setBackground(new Color(150, 0, 0));
        btnAcao.setForeground(Color.WHITE);
        btnAcao.setFocusPainted(false);
        btnAcao.setFont(new Font("Arial", Font.BOLD, 18));
        btnAcao.addActionListener(e -> executar());
        add(btnAcao, BorderLayout.SOUTH);

        configurarTimes();
        atualizarHPs();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JTextArea configurarPainelStatus(Color cor, String titulo) {
        JTextArea txt = new JTextArea(20, 20);
        txt.setBackground(new Color(40, 40, 40));
        txt.setForeground(cor);
        txt.setEditable(false);
        txt.setFont(new Font("Monospaced", Font.BOLD, 12));
        txt.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(cor), titulo, 
            TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, null, cor));
        return txt;
    }

    private void configurarTimes() {
        arena.adicionarLadoA(new GuardiaoDeFerro("Paladino", 13));
        arena.adicionarLadoA(new Bardo("Menestrel", 10));
        arena.adicionarLadoA(new Arcanista("Mago Branco", 13));

        arena.adicionarLadoB(new Necromante("Lich Rei", 8));
        arena.adicionarLadoB(new GuardiaoDeFerro("Orc Chefe", 9));
        arena.adicionarLadoB(new Arcanista("Warlock", 9));
    }

    private void atualizarHPs() {
       
        statusLadoA.setText("--- STATUS ---\n" + arena.getStatusEquipeA());
        statusLadoB.setText("--- STATUS ---\n" + arena.getStatusEquipeB());
    }

    private void executar() {
        if (!arena.acabou()) {
            List<String> logs = arena.rodada();
            for (String s : logs) {
                areaTexto.append(" > " + s + "\n");
            }
            areaTexto.append("--------------------------------------\n");
            areaTexto.setCaretPosition(areaTexto.getDocument().getLength());
            atualizarHPs(); // Atualiza a vida na lateral após cada rodada
        } else {
            String vencedor = arena.getVencedor();
            areaTexto.append("\n🏆 FIM DE JOGO! VENCEDOR: " + vencedor.toUpperCase() + "\n");
            btnAcao.setText("FIM DE BATALHA");
            btnAcao.setEnabled(false);
            JOptionPane.showMessageDialog(this, "A vitória pertence ao " + vencedor + "!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Jogo());
    }
}
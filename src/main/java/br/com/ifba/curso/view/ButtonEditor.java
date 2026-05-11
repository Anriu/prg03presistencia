package br.com.ifba.curso.view;

import java.awt.Component;
import javax.swing.*;

public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private int col;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);

        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value,
            boolean isSelected, int row, int column) {

        this.col = column;
        button.setText("");

        try {
            if (column == 4) {
                button.setIcon(new ImageIcon(getClass().getResource("br/com/ifba/imagens/remover.png")));
            } else if (column == 5) {
                button.setIcon(new ImageIcon(getClass().getResource("br/com/ifba/imagens/editar.png")));
            }
        } catch (Exception e) {
        }

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (col == 4) {
            int resposta = JOptionPane.showConfirmDialog(button,
                    "Deseja realmente excluir o curso?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION); 

            if (resposta == JOptionPane.YES_OPTION) {
                System.out.println("Remoção confirmada!");
            }
        } else if (col == 5) {
            System.out.println("Edição disparada!");
        }

        return "";
    }
}
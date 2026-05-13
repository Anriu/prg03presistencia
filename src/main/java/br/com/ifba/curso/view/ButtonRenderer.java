package br.com.ifba.curso.view;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {

        setText("");

        try {
            if (column == 5) {
                setIcon(new ImageIcon(getClass().getResource("imagens/remover.png")));
            } else if (column == 6) {
                setIcon(new ImageIcon(getClass().getResource("imagens/editar.png")));
            }
        } catch (Exception e) {
        }

        return this;
    }
}
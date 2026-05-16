package br.com.ifba.curso.view;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author anriu
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        // Deixa o botão com aparência transparente
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

        // Remove qualquer texto do botão
        setText("");

    try {

        // Emoji de excluir
        if (column == 3) {
            setText("Excluir");

        // Emoji de editar
        } else if (column == 4) {
            setText("Editar");
        }

        } catch (Exception e) {
    // Evita erros
    }

    // Retorna o botão para ser exibido na tabela
    return this;
    }
}
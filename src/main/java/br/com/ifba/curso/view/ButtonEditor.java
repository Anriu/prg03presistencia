package br.com.ifba.curso.view;

import br.com.ifba.curso.entity.Curso;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private int col;
    private int row;
    private JTable table;

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
        this.row = row;
        this.table = table;
        // 1. Instancia a entidade com o ID do curso existente
        Curso curso = new Curso();
        curso.setId(Long.parseLong(txtId.getText())); // O ID é essencial para edição
        curso.setNome(txtNome.getText());
        curso.setCodigoCurso(txtCodigo.getText());
        curso.setAtivo(chkAtivo.isSelected());

        try {
            entityManager.getTransaction().begin();
            // O merge atualiza o registro se o ID já existir [cite: 114, 115]
            entityManager.merge(curso); 
            entityManager.getTransaction().commit();
        
            JOptionPane.showMessageDialog(this, "Curso atualizado com sucesso!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + e.getMessage());
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
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // Remove a linha da tabela usando o índice armazenado
                model.removeRow(row);
            }
        } else if (col == 5) {
            // Lógica de edição (abrir tela) virá aqui
        }

        return "";
    }
}
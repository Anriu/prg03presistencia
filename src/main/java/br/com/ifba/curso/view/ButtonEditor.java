package br.com.ifba.curso.view;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private int col;
    private int row;
    private JTable table;
    private Object valor;

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
            JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {

        this.table = table;
        this.row = row;
        this.col = column;
        this.valor = value;

        return button;
    }

    @Override
    public Object getCellEditorValue() {

        if (col == 6) {
            int resposta = JOptionPane.showConfirmDialog(
                    button,
                    "Deseja realmente excluir o curso?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();

                Long id = Long.valueOf(model.getValueAt(row, 0).toString());

                CursoIDao cursoDao = new CursoDao();
                Curso curso = cursoDao.findById(id);

                cursoDao.delete(curso);

                SwingUtilities.invokeLater(() -> {
                    if (row >= 0 && row < model.getRowCount()) {
                        model.removeRow(row);
                    }
                });
            }

        } else if (col == 7) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Long id = Long.valueOf(model.getValueAt(row, 0).toString());

            CursoIDao cursoDao = new CursoDao();

            Curso curso = cursoDao.findById(id);

            DadosCurso tela = new DadosCurso(curso);
            tela.setVisible(true);
        }

        return valor;
    }
}
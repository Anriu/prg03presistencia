package br.com.ifba.curso.view;

import br.com.ifba.curso.controller.CursoController;
import br.com.ifba.curso.controller.CursoIController;
import br.com.ifba.curso.entity.Curso;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anriu
 */
public class ButtonEditor extends DefaultCellEditor {

    // Botão usado dentro da célula da tabela
    protected JButton button;

    // Guarda a coluna clicada
    private int col;

    // Guarda a linha clicada
    private int row;

    // Guarda a tabela onde o botão foi clicado
    private JTable table;

    // Guarda o valor da célula
    private Object valor;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);

        // Cria o botão
        button = new JButton();

        // Deixa o botão com aparência transparente
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);

        // Finaliza a edição da célula ao clicar no botão
        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {

        // Guarda os dados da célula clicada
        this.table = table;
        this.row = row;
        this.col = column;
        this.valor = value;

        return button;
    }

    @Override
    public Object getCellEditorValue() {

        // Verifica se a coluna clicada é a de remover
        if (col == 3) {

            int resposta = JOptionPane.showConfirmDialog(
                    button,
                    "Deseja realmente excluir o curso?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            // Se o usuário confirmar, remove o curso
            if (resposta == JOptionPane.YES_OPTION) {

                DefaultTableModel model =
                        (DefaultTableModel) table.getModel();

                // Pega o ID do curso na tabela
                Long id = Long.valueOf(
                        model.getValueAt(row, 0).toString()
                );

                // Cria o controller
                CursoIController cursoController =
                        new CursoController();

                // Busca o curso pelo ID
                Curso curso = cursoController.findById(id);

                // Remove o curso do banco
                cursoController.delete(curso);

                // Remove a linha da tabela
                SwingUtilities.invokeLater(() -> {

                    if (row >= 0 && row < model.getRowCount()) {
                        model.removeRow(row);
                    }
                });
            }

        // Verifica se a coluna clicada é a de editar
        } else if (col == 4) {

            DefaultTableModel model =
                    (DefaultTableModel) table.getModel();

            // Pega o ID do curso na tabela
            Long id = Long.valueOf(
                    model.getValueAt(row, 0).toString()
            );

            // Cria o controller
            CursoIController cursoController =
                    new CursoController();

            // Busca o curso pelo ID
            Curso curso = cursoController.findById(id);

            // Abre a tela de edição do curso
            DadosCurso tela = new DadosCurso(curso);
            tela.setVisible(true);
        }

        // Retorna o valor da célula
        return valor;
    }
}
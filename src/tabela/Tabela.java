//Criar tabela - Henrique Andrew da Silva

package tabela;

//Classes para gerenciar Eventos, Layouts
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

//Classes para construir Tabela
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

//Classes para construir a Janela e seus componentes
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

//---------------------------------------------------------

public class Tabela implements ActionListener {
    
    private static JFrame janela = new JFrame("Teste de Tabela");

	private JButton btInsLin = new JButton("Inserir");
	private JButton btFecJan = new JButton("Sair");

	private DefaultTableModel modelo = new DefaultTableModel();
	
	private JTable tabela = new JTable(modelo);

	private JScrollPane barRolTab = new JScrollPane(tabela);

	private static Tabela ft = new Tabela();

	//----------------------------

	public void criaJanela(){

		janela.setTitle("Novo Titulo");
		janela.setSize(500,500);
		
		//criar colunas
		modelo.addColumn("Nº Lin");
		modelo.addColumn("Codigo");
		modelo.addColumn("Nome");

		//definir dimensão necessaria para aparecer a barra de rolanegem na TABELA
		tabela.setPreferredScrollableViewportSize(new Dimension(400,150));

		//adiconar tabela + barra de rolagem na janela
		janela.add(barRolTab);


		//teclas de atalho
		btInsLin.setMnemonic('I');
		btFecJan.setMnemonic('S');

		janela.add(btInsLin);
		janela.add(btFecJan);
		
		btInsLin.addActionListener(ft);
		btFecJan.addActionListener(ft);

		janela.setLayout(new FlowLayout());
		janela.setVisible(true);

	}

	//----------------------------

    @Override
	public void actionPerformed(ActionEvent evt){

		if(evt.getSource().equals(btInsLin)){

			String cod = JOptionPane.showInputDialog(null, "Informe o Código");
			String nome = JOptionPane.showInputDialog(null, "Informe o Nome");

			int pos = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a posiçao desejada (deve ser positivo e <="+modelo.getRowCount()+" )"));

			//testa validade da posição informada
			if(pos > modelo.getRowCount()){
				JOptionPane.showMessageDialog(null, "O valor informado deve ser posivto e <= "+ modelo.getRowCount());
			}

			String linha = Integer.toString(modelo.getRowCount());

			modelo.insertRow(pos, new Object[]{linha, cod, nome});
			
		}

		if(evt.getSource().equals(btFecJan)){
			janela.dispose();
		}

	}

	//----------------------------

    public static void main(String[] args) {
        
        janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
		//janela.setDefaultCloseOperation(janela.DISPOSE_ON_CLOSE);

		ft.criaJanela();
    }
    
}
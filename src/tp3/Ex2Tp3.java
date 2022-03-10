package tp3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex2Tp3 {
	public static void main(String[] args) { 

		 EventQueue.invokeLater(new Runnable() { 
			public void run() { 
				Ex2  f = new Ex2 ("Ex2");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(500,175);
				f.setVisible(true);  
			}
		 }); 
		}
}

class Ex2 extends JFrame{
	String[] paimentStrings = { "MasterCard", "Visa","American Express","Carte Bleue"};
	public Ex2(String tit) {
		super(tit);
		
		JPanel p= new JPanel(new GridBagLayout());
		p.setBackground(Color.yellow);
		GridBagConstraints gbc= new GridBagConstraints();
		
		JLabel titre = new JLabel("Achetez maintenant !");
		titre.setForeground(Color.blue);
		JLabel nom = new JLabel("Nom:");
		nom.setForeground(Color.blue);
		JLabel adresse = new JLabel("Adresse:");
		adresse.setForeground(Color.blue);
		JLabel paiement = new JLabel("Mode de paiement:");
		paiement.setForeground(Color.blue);
		JLabel ville = new JLabel("Ville:");
		ville.setForeground(Color.blue);
		JLabel code = new JLabel("Code:");
		code.setForeground(Color.blue);
		JTextField nomField = new JTextField(30);
		JTextField adresseField = new JTextField(30);
		JTextField villeField = new JTextField(15);
		JTextField codeField = new JTextField(5);
		JComboBox modePaiement = new JComboBox(paimentStrings);
		titre.setFont(new Font("Times-Roman",Font.BOLD+ Font.ITALIC, 16));
		
		gbc.gridwidth= GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(5,0,10,0);
		p.add(titre,gbc);
		//Nom et adresse
		gbc.anchor = GridBagConstraints.WEST; //conservé pour la suite
		gbc.insets = new Insets(0,5,0,5); //conservé pour la suite
		gbc.gridwidth= 1;
		p.add(nom,gbc);
		gbc.gridwidth= GridBagConstraints.REMAINDER;
		p.add(nomField,gbc);
		gbc.gridwidth= 1;
		p. add(adresse, gbc);
		gbc.gridwidth= GridBagConstraints.REMAINDER;
		p.add(adresseField,gbc);
		gbc.gridwidth= 1;
		p. add(ville, gbc);
		p. add(villeField, gbc);
		p. add(code, gbc);
		p. add(codeField, gbc);
		gbc.gridwidth= 1;
		gbc.insets = new Insets(5,5,5,5);
		p. add(paiement, gbc);
		gbc.gridwidth= GridBagConstraints.REMAINDER;
		p. add(modePaiement, gbc);
		
		this.add(p);
	}
	
}

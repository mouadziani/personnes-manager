package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Personne;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class Stagiaire extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricule;
	private JTextField txtNom;
	private JTextField txtPrenom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stagiaire frame = new Stagiaire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Initial
	List<Personne> personnes = new ArrayList<Personne>();

	// Methods
	// Add
	public void ajouter(Personne personne) {
		this.personnes.add(personne);
	}
	
	// Update
	public void modifier(Personne personne) {
		for (Personne currentPersonne: personnes) {
			if(currentPersonne.equals(personne.getMatricule())) {
				currentPersonne.setNom(personne.getNom());
				currentPersonne.setPrenom(personne.getPrenom());
				break;
			}
		}
	}
	
	// Delete
	public void supprimer(String matricule) {
		for (Personne currentPersonne: personnes) {
			if(currentPersonne.equals(matricule)) {
				this.personnes.remove(currentPersonne);
				break;
			}
		}
	}
	
	// Find 
	public Personne chercher(String matricule) {
		for (Personne currentPersonne: personnes) {
			if(currentPersonne.equals(matricule)) {
				return currentPersonne;
			}
		}
		
		return null;
	}
	
	public void clear()
	{
		txtMatricule.setText("");
		txtNom.setText("");
		txtPrenom.setText("");
	}
	
	/**
	 * Create the frame.
	 */
	public Stagiaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMatricule = new JTextField();
		txtMatricule.setBounds(10, 18, 264, 28);
		contentPane.add(txtMatricule);
		txtMatricule.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(10, 57, 264, 28);
		contentPane.add(txtNom);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(10, 96, 264, 28);
		contentPane.add(txtPrenom);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		
		btnNouveau.setBounds(295, 18, 260, 28);
		contentPane.add(btnNouveau);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Personne personne = new Personne(txtMatricule.getText(), txtNom.getText(), txtPrenom.getText());
				ajouter(personne);
				clear();
			}
		});
		btnAjouter.setBounds(295, 57, 118, 28);
		contentPane.add(btnAjouter);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personne personne = chercher(txtMatricule.getText());
				txtMatricule.setText(personne.getMatricule());
				txtNom.setText(personne.getNom());
				txtPrenom.setText(personne.getPrenom());
			}
		});
		btnRechercher.setBounds(437, 60, 118, 28);
		contentPane.add(btnRechercher);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personne personne = new Personne(txtMatricule.getText(), txtNom.getText(), txtPrenom.getText());
				modifier(personne);
				clear();
			}
		});
		btnModifier.setBounds(295, 96, 118, 28);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimer(txtMatricule.getText());
				clear();
			}
		});
		btnSupprimer.setBounds(437, 99, 118, 28);
		contentPane.add(btnSupprimer);
	}
}

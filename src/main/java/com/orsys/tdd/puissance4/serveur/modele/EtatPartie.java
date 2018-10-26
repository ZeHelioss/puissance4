package com.orsys.tdd.puissance4.serveur.modele;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orsy.tdd.puissance4.client.ClientPuissance4;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EtatPartie {
	
	private int etat = ClientPuissance4.DECONNECTE;
	private final int nbLIG = 6;
	private final int nbCOL = 7;
	private String[][] grille = new String[nbLIG][nbCOL];
	private String couleur;
    private boolean[] etatBoutonsCol = new boolean[7];
    
    public EtatPartie( ) {
    	for (int i = 0; i < nbLIG; i++) {
			for (int j = 0; j < nbCOL; j++) {
				grille[i][j] = "V";
			}

		}
    }
	
	public EtatPartie( String[][] grille) {
		this.grille = grille;
		Arrays.fill( etatBoutonsCol, false);
	}
	
	public String[][] getGrille() {
		return grille;
	}
	
	public void setGrille( String[][] grille ) {
		this.grille = grille; 
	}

	public int getEtat() {
		return etat;
	}

    public boolean[] getEtatBoutonsCol() {
    	return etatBoutonsCol;
    }
	
    public void setEtatBoutonCol( int col , boolean etat ) {
        etatBoutonsCol[ col-1 ] = etat;  	
    }
    
	public void setEtat(int etat) {
		this.etat = etat;
	}


	@Override
	public String toString() {
		String s = "erreur de traitement json";
		ObjectMapper mapper = new ObjectMapper();
		try {
			s = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			System.out.println("Erreur de JSon");
		} 
		return s;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
		
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
    
}

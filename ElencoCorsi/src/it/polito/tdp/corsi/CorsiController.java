/**
 * Sample Skeleton for 'Corsi.fxml' Controller Class
 */

package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CorsiController {
	
	Model model = new Model ();
	
	public void setModel(Model model) {
		this.model = model ;
		
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtSemestre"
    private TextField txtSemestre; // Value injected by FXMLLoader

    @FXML // fx:id="txtLog"
    private TextArea txtLog; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
    	
    	txtLog.clear();
    	
    	try {
    		int pd = Integer.parseInt(txtSemestre.getText());
    		
    		if(pd != 1 && pd!=2)
    		{
    			txtLog.setText("Inserire un periodo didattico (1 o 2)");
    		}
    		
        	//Faccio la richiesta al model , per ottenere i Corsi
        	List<Corso> corsi = model.listaCorsiSemestre(pd);
        	for(Corso c : corsi)
        	{
        		txtLog.appendText(c.toString() + "\n");
        	}
			
		} catch (NumberFormatException e) {
			 txtLog.setText("Inserire un periodo didattico (1 o 2)");
		}
    	
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtSemestre != null : "fx:id=\"txtSemestre\" was not injected: check your FXML file 'Corsi.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'Corsi.fxml'.";

    }


}


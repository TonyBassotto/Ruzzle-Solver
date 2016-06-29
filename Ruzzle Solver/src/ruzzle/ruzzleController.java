package ruzzle;


import java.beans.EventHandler;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.mainx;

public class ruzzleController {

	mainx m=new mainx();
	Map<String, boolean[][]> mappatemp;
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private ProgressBar progressbar;

    Service<Void> bgt;

    @FXML
    private URL location;

    @FXML
    private TextField char00;

    @FXML
    private TextField char01;

    @FXML
    private TextField char02;

    @FXML
    private TextField char03;

    @FXML
    private TextField char10;

    @FXML
    private TextField char11;

    @FXML
    private TextField char12;

    @FXML
    private TextField char13;

    @FXML
    private TextField char20;

    @FXML
    private TextField char21;

    @FXML
    private TextField char22;

    @FXML
    private TextField char23;

    @FXML
    private TextField char30;

    @FXML
    private TextField char31;

    @FXML
    private TextField char32;

    @FXML
    private TextField char33;

    @FXML
    private Button BTNGENERATE;

    @FXML
    private ListView<String> LIST_SOLUTION;

    @FXML
    void CLICKGENERATE(ActionEvent event) {
    	bgt =new Service<Void>(){
    		@Override
			protected
    		Task<Void> createTask() {
    			 return new Task<Void>(){
    				 @Override
					public
    				 	Void call() throws Exception{
			    			updateProgress(-1.0,-1.0);
			    			//progressbar.setProgress(-1);
			    			BTNGENERATE.setDisable(true);
			
			    			char00.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char01.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char02.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char03.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char10.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char11.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char12.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char13.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char20.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char21.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char22.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char23.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char23.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char30.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char31.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char32.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char33.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
			    			char00.setText("");
			    	    	char01.setText("");
			    	    	char02.setText("");
			    	    	char03.setText("");
			    	    	char10.setText("");
			    	    	char11.setText("");
			    	    	char12.setText("");
			    	    	char13.setText("");
			    	    	char20.setText("");
			    	    	char21.setText("");
			    	    	char22.setText("");
			    	    	char23.setText("");
			    	    	char30.setText("");
			    	    	char31.setText("");
			    	    	char32.setText("");
			    	    	char33.setText("");
			    	    	LIST_SOLUTION.getItems().clear();
			    	    	LIST_SOLUTION.getSelectionModel().clearSelection();
			    	    	
			
			    	        //m.starte();
			    	    	m.EXE();
			    	    	updateProgress(1,1);
			    			//progressbar.setProgress(1);

			    	    	mappatemp=m.mappaX();
			    	    	BTNGENERATE.setDisable(false);
			    	    	LIST_SOLUTION.getItems().addAll(m.listacontroller());
			    	    	String[][] x=m.getruzzle();
			    	    	//String s=x[0][0];
			    	    	//System.out.println(s);
			    	    	char00.setText(x[0][0]);
			    	    	char01.setText(x[0][1]);
			    	    	char02.setText(x[0][2]);
			    	    	char03.setText(x[0][3]);
			    	    	char10.setText(x[1][0]);
			    	    	char11.setText(x[1][1]);
			    	    	char12.setText(x[1][2]);
			    	    	char13.setText(x[1][3]);
			    	    	char20.setText(x[2][0]);
			    	    	char21.setText(x[2][1]);
			    	    	char22.setText(x[2][2]);
			    	    	char23.setText(x[2][3]);
			    	    	char30.setText(x[3][0]);
			    	    	char31.setText(x[3][1]);
			    	    	char32.setText(x[3][2]);
			    	    	char33.setText(x[3][3]);
			    	    	
							return null;
    			
    				 		}
    			 		};
    				}
    			};

    	
    			progressbar.progressProperty().bind(bgt.progressProperty());
    			bgt.restart();
    			//Thread th=new Thread(bgt);
    			//th.setDaemon(true);
    			//th.start();
    	
    }
    @FXML
    void checkValidate(MouseEvent event) {
    	String s=LIST_SOLUTION.getSelectionModel().getSelectedItem();
    	if(s==null){}
    	else{
		char00.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char01.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char02.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char03.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char10.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char11.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char12.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char13.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char20.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char21.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char22.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char23.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char23.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char30.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char31.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char32.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char33.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		

    	System.out.println(s);
    	boolean[][] x=mappatemp.get(s);
    	for(int i=0;i<16;i++){
    	System.out.println(x[i/4][i%4]);
    	}
    	if(x[0][0]==true){
    		char00.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[0][1]==true){
    		char01.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[0][2]==true){
    		char02.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[0][3]==true){
    		char03.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}
    	if(x[1][0]==true){
    		char10.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[1][1]==true){
    		char11.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[1][2]==true){
    		char12.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[1][3]==true){
    		char13.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}
    	if(x[2][0]==true){
    		char20.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[2][1]==true){
    		char21.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[2][2]==true){
    		char22.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[2][3]==true){
    		char23.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}
    	if(x[3][0]==true){
    		char30.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[3][1]==true){
    		char31.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[3][2]==true){
    		char32.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}if(x[3][3]==true){
    		char33.setStyle("-fx-background-color:orange;-fx-text-fill:black");
    	}
    	}
    	
    }
    

    @FXML
    void initialize() {
        assert char00 != null : "fx:id=\"char00\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char01 != null : "fx:id=\"char01\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char02 != null : "fx:id=\"char02\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char03 != null : "fx:id=\"char03\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char10 != null : "fx:id=\"char10\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char11 != null : "fx:id=\"char11\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char12 != null : "fx:id=\"char12\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char13 != null : "fx:id=\"char13\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char20 != null : "fx:id=\"char20\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char21 != null : "fx:id=\"char21\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char22 != null : "fx:id=\"char22\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char23 != null : "fx:id=\"char23\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char30 != null : "fx:id=\"char30\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char31 != null : "fx:id=\"char31\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char32 != null : "fx:id=\"char32\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert char33 != null : "fx:id=\"char33\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert BTNGENERATE != null : "fx:id=\"BTNGENERATE\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert LIST_SOLUTION != null : "fx:id=\"LIST_SOLUTION\" was not injected: check your FXML file 'ruzzle.fxml'.";
        assert progressbar != null : "fx:id=\"progressbar\" was not injected: check your FXML file 'ruzzle.fxml'.";

      //  LIST_SOLUTION.setStyle(value);
        char00.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char01.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char02.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char03.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char10.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char11.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char12.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char13.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char20.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char21.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char22.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char23.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char23.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char30.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char31.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char32.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		char33.setStyle("-fx-background-color:#444444;-fx-text-fill:white");
		//char00.setStyle("-fx-background-color: orange;");
		//char00.setText("L");

    }
}
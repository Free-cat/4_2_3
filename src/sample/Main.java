package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    public TextField arg1;
    public TextField step1;
    public TextField arg2;
    public TextField step2;
    public Button add2;
    public Button add1;
    public Button go;
    public Label mnog2;
    public Label mnog1;
    public Label answer;
    public Map<Integer, Integer> hashMap1 = new HashMap<Integer, Integer>();
    public Map<Integer, Integer> hashMap2 = new HashMap<Integer, Integer>();
    public String labeltext1 = "";
    public String labeltext2 = "";
    public String answerString = "";
    public int maxstep = 0;



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 4_2");
        primaryStage.setScene(new Scene(root, 400, 330));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void add2(ActionEvent actionEvent) {
        int arg1 = Integer.parseInt(arg2.getText());
        int step1 = Integer.parseInt(step2.getText());
        hashMap2.put(step1, arg1);
        if (step1 > maxstep) maxstep = step1;
        labeltext2 += "(" + arg1 + "x^" + step1 + ")" + "*";
        mnog2.setText(labeltext2);
        mnog2.setVisible(true);
    }

    public void add1(ActionEvent actionEvent) {
        int arg = Integer.parseInt(arg1.getText());
        int step = Integer.parseInt(step1.getText());
        hashMap1.put(step, arg);
        if (step > maxstep) maxstep = step;
        labeltext1 += "(" + arg + "x^" + step + ")" + "*";
        mnog1.setText(labeltext1);
        mnog1.setVisible(true);
    }

    public void go(ActionEvent actionEvent) {
        /*int n = 0;
        int m = 0;
        if (hashMap1.size() > hashMap2.size()) {
            n = hashMap1.size();
        }
        else {
            n = hashMap2.size();
        }*/
        for (int i = 0; i < maxstep+1; i++){
            Integer frequency = hashMap1.get(i);
            if (frequency == null)
            hashMap1.put(i, 0);
        }

        for (int i = 0; i < maxstep+1; i++){
            Integer frequency = hashMap2.get(i);
            if (frequency == null)
                hashMap2.put(i, 0);
        }

        for (int i = maxstep; i>0; i--){
            int argus = hashMap2.get(i) + hashMap1.get(i);
            answerString += argus + "x^" + i + "+";
        }
        answer.setText(answerString);
        answer.setVisible(true);
    }
}

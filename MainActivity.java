package com.example.calc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private static int achei=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.text1);
    }

    public String verifica(String L){
        String corpo;
        char [] letras;
        int tamanho;

        corpo = (String) texto.getText();
        letras = corpo.toCharArray();
        tamanho = letras.length - 1;
        String caracter = String.valueOf(letras[tamanho]);
        if (tamanho == 0) {
            corpo = " ";
            if (L.equals("-")){
                corpo += L;
            }
        }else{
            if (caracter.equals("+") || caracter.equals("X") || caracter.equals("/") || caracter.equals("-") || caracter.equals(".")) {
                corpo = corpo.substring(0, tamanho + 1);
            } else {
                if (L.equals(".")) {
                    corpo = corpo + L;
                }else{
                    if (achei == 0) {
                        achei++;
                        corpo = corpo + L;
                    }
                }
            }
        }
        return corpo;
    }

    public void Main(View v) {
        int id = v.getId();
        String corpo;
        char[] letras;
        int tamanho;
        switch (id) {
            case R.id.button1:
                corpo = (String) texto.getText();
                corpo += "1";
                texto.setText(corpo);
                break;

            case R.id.button2:
                corpo = (String) texto.getText();
                corpo += "2";
                texto.setText(corpo);
                break;

            case R.id.button3:
                corpo = (String) texto.getText();
                corpo += "3";
                texto.setText(corpo);
                break;

            case R.id.button4:
                corpo = (String) texto.getText();
                corpo +="4";
                texto.setText(corpo);
                break;

            case R.id.button5:
                corpo = (String) texto.getText();
                corpo +="5";
                texto.setText(corpo);
                break;

            case R.id.button6:
                corpo = (String) texto.getText();
                corpo +="6";
                texto.setText(corpo);
                break;

            case R.id.button7:
                corpo = (String) texto.getText();
                corpo += "7";
                texto.setText(corpo);
                break;

            case R.id.button8:
                corpo = (String) texto.getText();
                corpo += "8";
                texto.setText(corpo);
                break;

            case R.id.button9:
                corpo = (String) texto.getText();
                corpo += "9";
                texto.setText(corpo);
                break;

            case R.id.button10:
                corpo = (String) texto.getText();
                corpo += "0";
                texto.setText(corpo);
                break;

            case R.id.button11:
                texto.setText(verifica("+"));
                break;

            case R.id.button12:
                texto.setText(verifica("-"));
                break;

            case R.id.button13:
                texto.setText(verifica("X"));
                break;

            case R.id.button14:
                texto.setText(verifica("/"));
                break;

            case R.id.button15:
                texto.setText(verifica("."));
                break;

            case R.id.button16:
                corpo = (String) texto.getText();
                letras = corpo.toCharArray();
                tamanho = letras.length - 1;
                String ultimo = String.valueOf(letras[tamanho]);
                if (tamanho == 0) {
                    corpo = " ";
                } else {
                    if (ultimo.equals("+") || ultimo.equals("X") || ultimo.equals("/") || ultimo.equals("-")) {
                        achei = 0;
                    }
                    corpo = corpo.substring(0, tamanho);
                }
                texto.setText(corpo);
                break;

            case R.id.button17:
                corpo = (String) texto.getText();
                letras = corpo.toCharArray();
                tamanho = letras.length - 1;
                String[] parteString = new String[2];
                String caracter2;
                for (int i = 0; i < 2; i++) {
                    parteString[i] = "";
                }
                float[] parteFloat = new float[2];
                float res = 0;
                for (int i = 0; i < tamanho; i++) {
                    String caracter = String.valueOf(letras[i]);
                    if (caracter.equals("+") || caracter.equals("X") || caracter.equals("/") || caracter.equals("-") && i != 1) {
                        System.out.println(corpo);
                        for (int j=0; j < i; j++) {
                            caracter2 = String.valueOf(letras[j]);
                            if (caracter2.equals(" ")) {
                                System.out.println("entrastes " + j);
                            } else {
                                System.out.println("entrou");
                                parteString[0] += caracter2;
                            }
                        }
                        System.out.println();
                        for (int j = i + 1; j <= tamanho; j++) {
                            caracter2 = String.valueOf(letras[j]);
                            if (caracter2.equals(" ")) {
                            } else {
                                parteString[1] += caracter2;
                            }
                        }
                        System.out.println("isso " + parteString[0] + " e " + parteString[1]);
                        parteFloat[0] = Float.parseFloat(parteString[0]);
                        parteFloat[1] = Float.parseFloat(parteString[1]);
                        switch (caracter) {
                            case "+":
                                    res = parteFloat[0] + parteFloat[1];
                                break;

                            case "-":
                                res = parteFloat[0] - parteFloat[1];
                                break;

                            case "X":
                                res = parteFloat[0] * parteFloat[1];
                                break;

                            case "/":
                                if (parteFloat[1] != 0) {
                                    res = parteFloat[0] / parteFloat[1];
                                }
                                break;
                        }
                    }
                }
                achei = 0;
                texto.setText(" " + String.valueOf(res));
                break;

            case R.id.button18:
                corpo = " ";
                achei = 0;
                texto.setText(corpo);
                break;
        }
    }
}

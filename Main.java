package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            int peso = 10;
            int total = 0;
            int digito1 = 0, digito2 = 0;
            Scanner input = new Scanner(System.in);

        System.out.println("Digite o seu cpf: ");

        while(true){
            String cpf = input.next();
            // validando a quantidade de caracteres
            if (cpf.length() != 11){
                System.out.println("Digite onze caracteres.");
            }else {

                if(cpf.equals("00000000000")||
                        cpf.equals("11111111111")||
                        cpf.equals("22222222222")||
                        cpf.equals("33333333333")||
                        cpf.equals("44444444444")||
                        cpf.equals("55555555555")||
                        cpf.equals("66666666666")||
                        cpf.equals("77777777777")||
                        cpf.equals("88888888888")||
                        cpf.equals("99999999999") ){

                    System.out.println("CPF inválido.");

                }else{
                    //pegando os digitos verificadores inseridos e armazenando em variaveis para
                    //comparação com os digitos calculados
                    int verificador1 = Integer.parseInt(cpf.substring(9,10));
                    int verificador2 = Integer.parseInt((cpf.substring(10,11)));


                    //calculo do primeiro digito
                    for (int i= 0; i <= 8; i++){
                        total += Integer.parseInt(cpf.substring(i,i+1))*peso;
                        peso = peso - 1;
                    }

                    //calculando o resto
                    int resto = total % 11;
                    if (resto > 2){
                        digito1 = 11 - resto;
                    }else{
                        digito1 = 0;
                    }


                    if (digito1 == verificador1){
                        //resetando os valores para o calculo do segundo digito
                        peso = 11;
                        total = 0;
                        for (int i= 0; i <= 9; i++){
                            total += Integer.parseInt(cpf.substring(i,i+1))*peso;
                            peso = peso - 1;
                        }

                        resto = total % 11;
                        if(resto > 2){
                            digito2 = 11 - resto;
                        }else{
                            digito2 = 0;
                        }

                        //comparando o segundo digito se o primeiro for igual
                        if (digito2 == verificador2){
                            System.out.println("O CPF é válido.");
                        }
                    }else {
                        System.out.println("CPF inválido.");
                    }
                    break;
                }

            }

    }
}}
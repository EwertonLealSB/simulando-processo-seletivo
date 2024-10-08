package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"Felipe","Marcia","Julia","Paulo","Augusto"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando =!atendeu;

            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso");
        } while(continuarTentando && tentativasRealizadas<3);
        
        if(atendeu)
            System.out.println("Conseguimos contato com "  + candidato + " na " + tentativasRealizadas + " tentativa");
        else 
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas);

    }

    //Método auxiliar 
    static boolean atender(){
        return new Random().nextInt(3)==1;

    }

    static void imprimirSelecionados(){
        String [] candidatos = {"Felipe","Marcia","Julia","Paulo","Augusto"};

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for(int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de nº" + (indice+1) + " é o " + candidatos[indice]);
        }
        System.out.println("Forma abreviada de interpretação for each");

        for(String canditato: candidatos ){
            System.out.println("O candidato selecionado foi " + canditato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Felipe","Marcia","Paulo","Augusto","Monica","Fabricio","Mirela","Daniela","Jorge"};    

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato: %s. Solicitou este valor de salario: %.2f\n ", candidato, salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.printf("O candidato %s foi selecionado para a vaga\n", candidato);
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o canditato");

        } else if (salarioBase == salarioPretendido)
            System.out.println("Ligar para o canditato com contra proposta");

        else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}

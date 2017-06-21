package Problema_Mochila;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author YU7
 */
public class AplicacaoAG {

    private final int valorObj[];
    private final int pesoObj[];
    private ArrayList<String> _POPULACAO;
    private final JTextArea console;

    public AplicacaoAG(int[] valores, int[] pesos, JTextArea textarea) {

        this.valorObj = valores;
        this.pesoObj = pesos;
        this.console = textarea;

    }

    public void exibePopulacao(ArrayList<String> populacao) {
        this._POPULACAO = populacao;
        console.append("População >> " + populacao + "\n");
    }

    public int calculaAptidao(String _DNA) {

        /*  
        utiliza o Vetor de valorObj para calcular a aptão retorna o valor da aptdão 
        ou retorna 0 caso o mesmo ultrapasse o peso de 25KG, calulado pela função validaCromossomo
         */
        int aptdao = -1;

        if (validaCromossomo(_DNA)) {
            for (int i = 0; i < _DNA.length(); i++) {
                String aux = String.valueOf(_DNA.charAt(i));
                if (aux.equals("1")) {
                    aptdao += valorObj[i];
                }
            }
        }

        return aptdao;

    }

    public boolean validaCromossomo(String _DNA) {

        /*
        tilizando o vetor global de pesoObj para calcula o peso.  
        retorna um valor Booleano no caso do cromossomo ter o
        peso menor ou igual a 25.  
         */
        int peso = 0;

        for (int i = 0; i < _DNA.length(); i++) {
            String aux = String.valueOf(_DNA.charAt(i));
            if (aux.equals("1")) {
                peso += pesoObj[i];
            }
        }

        return peso <= 25;

    }

    public String Crossover(String c1, String c2) {

        /*
        Função de crossover de cromossomos, pega a metade (1 parte) do cromossomo c1
        mais a metade (2 parte) do cromossomo c2, depois o mesmo com c2 (1 parte) + c1 (2 parte)
         */
        String filho = c1.substring(0, c1.length() / 2) + c2.substring(c2.length() / 2);

        return filho;

    }

    public String Mutacao(String cromossomo) {

   /*  Sorteia uma posição da String e altera o valor e retorna outra String */
        Random rd = new Random();
        int pos = rd.nextInt(cromossomo.length());
//        System.out.println("mutação na posicao: " + pos);

        char[] aux = cromossomo.toCharArray();

        for (int i = 0; i < aux.length; i++) {
            if (i == pos) {
                if (aux[pos] == '1') {
                    aux[pos] = '0';
                } else {
                    aux[pos] = '1';
                }
            }
        }

        return String.valueOf(aux);
    }

    public ArrayList<String> aplicaCrossover(ArrayList<String> idvs) {

        ArrayList<String> filhos = new ArrayList<>();
        
        filhos.add(Crossover(idvs.get(0), idvs.get(1)));
        filhos.add(Crossover(idvs.get(1), idvs.get(2)));
        filhos.add(Crossover(idvs.get(3), idvs.get(4)));
        filhos.add(Crossover(idvs.get(4), idvs.get(3)));

        console.append("Aplicando Crossover >> "+filhos+"\n");
        return filhos;
    }

    public ArrayList<String> aplicaMutacao(ArrayList<String> idvs){
        
        ArrayList<String> mutacao = new ArrayList<>();
        
        mutacao.add(Mutacao(idvs.get(0)));
        mutacao.add(Mutacao(idvs.get(1)));
        mutacao.add(Mutacao(idvs.get(2)));
        mutacao.add(Mutacao(idvs.get(3)));
        
        console.append("Aplicando Mutação >> "+mutacao+"\n");
        return mutacao;
    }
    
    public ArrayList<String[]> selecaoPorAptdao() {

        //Descarta os individuos com aptidão -1 ou seja INVALIDO
        ArrayList<String[]> idvs = new ArrayList<>();
        int cont = 0;

        console.append("Calculo de Aptidões >> ");
        for (String idv : _POPULACAO) {
            int apt = calculaAptidao(idv); //Calcula a aptdao e adiciona no array aptds
            if (apt > -1) {
                idvs.add(new String[]{idv, String.valueOf(apt)});
                console.append("[" + idv + ", " + apt + "] ");
            } else {
                cont++;
            }
        }

        console.append("\nDescartados >> " + cont + " Individuos com o valor acima de 25KG\n");
        return idvs;

    }

    public ArrayList<String> selecaoPorRoleta(ArrayList<String[]> idvs) {

        float soma = 0;
        for (String[] apt : idvs) {
            soma += Float.parseFloat(apt[1]);
        }

        //Calcula o % de probabilidade de um idv ser escolhido e imprimi no console  
        console.append("Probabilidade de Escolha >>\n");
        for (String[] apt : idvs) {
            apt[1] = String.valueOf(soma / Float.parseFloat(apt[1]));
            console.append("[" + apt[0] + ", " + apt[1] + "%]\n");
        }

        //Ordena o melhores IDVS de acordo com a probabilidade de ser escolhido
        for (int i = 0; i < idvs.size(); i++) {
            String[] a = idvs.get(i);
            double prob1 = Double.parseDouble(a[1]);

            for (int j = i; j < idvs.size(); j++) {
                String[] b = idvs.get(j);
                double prob2 = Double.parseDouble(b[1]);

                if (prob2 > prob1) {
                    String[] c = idvs.get(j);
                    idvs.remove(j);
                    idvs.add(i, c);
                }
            }
        }

        ArrayList<String> melhores = new ArrayList();

        int cont = 0;
        for (String[] aux : idvs) {
            if (cont <= _POPULACAO.size() / 2) {
                melhores.add(aux[0]);
                cont++;
            }           
        }

        console.append("\nIndividuos Selecionados >> " + melhores + "\n");

        return melhores;

    }

    public ArrayList<String> GeraNovaPopulacao() {

        ArrayList<String[]> selecao = selecaoPorAptdao();
        ArrayList<String> pais = selecaoPorRoleta(selecao);
        ArrayList filhos = aplicaCrossover(pais);
        ArrayList mutacao = aplicaMutacao(filhos);
        ArrayList nova_populacao = new ArrayList();
        
        //Cria a nova populacao de inviduos
        nova_populacao.addAll(pais);
        nova_populacao.addAll(mutacao);
                
        console.append("Nova Populacao >> "+nova_populacao+"\n");
        
        return nova_populacao;

    }

}

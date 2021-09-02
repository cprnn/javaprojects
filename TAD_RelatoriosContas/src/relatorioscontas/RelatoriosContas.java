package relatorioscontas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RelatoriosContas {

    public static void main(String[] args) {

        TreeMap<Integer, ArrayList<Transacao>> mapTransaction = new TreeMap();

        try {

            JSONArray transacoes = leArquivoJSON("src/relatorioscontas/transactions.json");

            for (int i = 0; i < transacoes.length(); i++) {
                JSONObject obj = transacoes.getJSONObject(i);

                Transacao trans = new Transacao(obj.getInt("id_transacao"), obj.getInt("id_conta"), obj.getDouble("valor"));

                if (mapTransaction.containsKey(obj.getInt("id_conta"))) {

                    ArrayList<Transacao> tr = mapTransaction.get(obj.getInt("id_conta"));

                    tr.add(trans);
                    mapTransaction.replace(obj.getInt("id_conta"), tr);

                } else {
                    ArrayList<Transacao> tr = new ArrayList<Transacao>();

                    tr.add(trans);
                    mapTransaction.put(obj.getInt("id_conta"), tr);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (JSONException ex) {
            System.out.println("Erro na manipulação dos objetos JSON!");
        }

        Scanner scan = new Scanner(System.in);

        int op = 0;

        while (op != 9) {

            System.out.println("\n");
            System.out.println("MENU DO USUÁRIO:");
            System.out.println("1 - Relatório geral de todas as contas");
            System.out.println("2 - Relatório detalhado de uma conta específica");
            System.out.println("9 - Sair");
            System.out.println("\n");

            op = scan.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Conta\t Nº Trans.\tSaldo");
                    System.out.println("\n");

                    mapTransaction.entrySet().forEach(mapElement -> {

                        int id = mapElement.getKey();
                        int qntTr = 0;
                        double saldo = 0.0;

                        for (Transacao t : mapElement.getValue()) {
                            qntTr++;
                            saldo += t.getValor();
                        }
                        System.out.print(id + "\t" + qntTr + "\t");
                        System.out.printf("R$ %.2f", saldo);
                        System.out.println("");
                    });
                    break;

                case 2:
                    int id = 0;
                    double saldo = 0.0;

                    System.out.println("Informe o número da conta:");
                    id = scan.nextInt();
                    
                        System.out.println("Idº Trans.\tSaldo");
                        for (Transacao t : mapTransaction.get(id)) {
                            System.out.println(t.getIdTran()+ "\t" + "R$ " + t.getValor());
                        saldo += t.getValor();
                        }       
                    break;
            }
        }
        System.out.println("Agradecemos a preferência!");
    }

    public static JSONArray leArquivoJSON(String nomeArquivo) throws FileNotFoundException, JSONException {
        Scanner arquivo = new Scanner(new File(nomeArquivo));

        String jsonStr = "";
        while (arquivo.hasNext()) {
            jsonStr += arquivo.nextLine();
        }

        return new JSONArray(jsonStr);
    }

}

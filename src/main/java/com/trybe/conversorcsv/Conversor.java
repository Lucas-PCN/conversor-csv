package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Public class Conversor.
 *
 */
public class Conversor {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou
   *                     gravar os arquivos de saída.
   */
  public static void main(String[] args) throws IOException {
    File pastaDeEntradas = new File("./entradas/");
    File pastaDeSaidas = new File("./saidas/");
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados
   * na pasta de saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas Pasta em que serão colocados os arquivos gerados no formato
   *                      requerido pelo subsistema.
   *
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou
   *                     gravar os arquivos de saída.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {
    if (!pastaDeSaidas.exists()) {
      pastaDeSaidas.mkdir();
    }

    if (pastaDeEntradas.isDirectory() && pastaDeEntradas.canRead()) {
      for (File arquivoEmEntrada : pastaDeEntradas.listFiles()) {
        File arquivoEmSaida = new File(pastaDeSaidas + "/" + arquivoEmEntrada.getName());
        alterarArquivo(arquivoEmEntrada, arquivoEmSaida);
      }
    }
  }

  /**
   * Método para alterar o arquivo em saída.
   */
  public static void alterarArquivo(File arquivoEmEntrada, File arquivoEmSaida) throws IOException {
    if (arquivoEmEntrada.exists()) {
      FileReader fileReader = new FileReader(arquivoEmEntrada);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      FileWriter fileWriter = new FileWriter(arquivoEmSaida);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      String linhaLida = bufferedReader.readLine();
      bufferedWriter.write(linhaLida);
      bufferedWriter.newLine();
      bufferedWriter.flush();
      linhaLida = bufferedReader.readLine();

      while (linhaLida != null) {
        String[] infosInscrito = linhaLida.split(",");

        String nome = infosInscrito[0].toUpperCase();
        String data = alterarData(infosInscrito[1]);
        String email = infosInscrito[2];
        String cpf = alterarCpf(infosInscrito[3]);

        linhaLida = nome + "," + data + "," + email + "," + cpf;

        bufferedWriter.write(linhaLida);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        linhaLida = bufferedReader.readLine();
      }

      fileReader.close();
      bufferedReader.close();
      fileWriter.close();
      bufferedWriter.close();
    }
  }

  /**
   * Método para alterar a data.
   */
  public static String alterarData(String data) {
    String[] partes = data.split("/");
    String dataAlterada = partes[2] + "-" + partes[1] + "-" + partes[0];
    return dataAlterada;
  }

  /**
   * Método para alterar o cpf.
   */
  public static String alterarCpf(String cpf) {
    StringBuilder cpfAlterado = new StringBuilder(cpf);
    cpfAlterado.insert(3, ".");
    cpfAlterado.insert(7, ".");
    cpfAlterado.insert(11, "-");
    return cpfAlterado.toString();
  }
}
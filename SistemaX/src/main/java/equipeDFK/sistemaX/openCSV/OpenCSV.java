/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.openCSV;

import au.com.bytecode.opencsv.CSVReader;
import equipeDFK.sistemaX.entidades.Feriado;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilizada para leitura de arquivo CSV
 *
 * @author kaique
 */
public class OpenCSV {

    /**
     * Método usado para ler um arquivo csv e retornar uma {@linkplain List} de feriados
     *
     * @param filename
     * @return {@linkplain List}
     */
    public List<Feriado> lerCSV(File filename) {
        try {

            CSVReader reader = new CSVReader(new InputStreamReader(
                    new FileInputStream(filename), "UTF-8"), ';', '\'', 1);
            try {

                String[] values = reader.readNext();
                List<Feriado> feriados = new ArrayList<>();

                while (values != null) {
                    String feriado = values[0];
                    String split[] = feriado.split(",");

                    Feriado f = new Feriado();
                    f.setStart(split[0]);
                    f.setTitle(split[1]);
                    feriados.add(f);

                    values = reader.readNext();
                }

                return feriados.isEmpty() ? null : feriados;
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

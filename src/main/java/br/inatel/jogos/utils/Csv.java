/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.jogos.utils;

import br.inatel.jogos.model.Jogo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafa_
 */
public class Csv {
    public static List<Jogo> readCsv(Path csvFilePath){
        List<Jogo> jogos = new ArrayList<>();
        
        try {
            Reader reader = Files.newBufferedReader(csvFilePath);
            CsvToBean<Jogo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Jogo.class).withIgnoreLeadingWhiteSpace(true).build();
        } catch (IOException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jogos;
    }
}

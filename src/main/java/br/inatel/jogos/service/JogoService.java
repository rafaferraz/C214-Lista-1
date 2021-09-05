/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.jogos.service;

import br.inatel.jogos.model.Genre;
import br.inatel.jogos.model.Jogo;
import br.inatel.jogos.model.Platform;
import br.inatel.jogos.model.Publisher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafa_
 */
public class JogoService {
    public static List<Jogo> getByPlatform(List<Jogo> jogos, Platform plataformas){
        List<Jogo> jogosPorPlataforma = new ArrayList<>();

        jogos.stream().filter((jogo ->jogo.getPlatform().equals(plataformas.name())))
                .forEach(jogo -> jogosPorPlataforma.add(jogo));

        return jogosPorPlataforma;
    }

    public static List<Jogo> getByGenre(List<Jogo> jogos, Genre genero){
        List<Jogo> jogosPorGenero = new ArrayList<>();

        jogos.stream().filter((jogo ->jogo.getGenre().replaceAll("\\s+", "")
                .equals(genero.name()))).forEach(jogo -> jogosPorGenero.add(jogo));

        return jogosPorGenero;
    }
    
    public static List<Jogo> getByPublisher(List<Jogo> jogos, Publisher publisher){
        List<Jogo> jogosPorPublisher = new ArrayList<>();

        jogos.stream().filter((jogo ->jogo.getPublisher().replaceAll("\\s+", "")
                .equals(publisher.name()))).forEach(jogo -> jogosPorPublisher.add(jogo));

        return jogosPorPublisher;
    }
}

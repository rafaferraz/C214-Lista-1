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
import br.inatel.jogos.utils.Csv;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rafa_
 */
public class TestJogos {
    private static List<Jogo> jogos;
    
    @BeforeClass
    public static void initClass() throws URISyntaxException{
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        jogos = Csv.readCsv(caminho);
    }
    
    @Test
    public void testJogosNintendo(){
        List<Jogo> jogosNintendo = JogoService.getByPublisher(jogos, Publisher.Nintendo);
        Assert.assertEquals(52, jogosNintendo.size());
    }
    
    @Test
    public void testJogosEA(){
        List<Jogo> jogosEA = JogoService.getByPublisher(jogos, Publisher.ElectronicArts);
        Assert.assertEquals(5, jogosEA.size());
    }
    
    @Test
    public void testJogosWii(){
        List<Jogo> jogosWii = JogoService.getByPlatform(jogos, Platform.Wii);
        Assert.assertEquals(16, jogosWii.size());
    }

    @Test
    public void testJogosPuzzle(){
        List<Jogo> jogosPuzzle = JogoService.getByGenre(jogos, Genre.Puzzle);
        Assert.assertEquals(3, jogosPuzzle.size());
    }
    
    @Test
    public void testJogosShooter(){
        List<Jogo> jogosShooter = JogoService.getByGenre(jogos, Genre.Shooter);
        Assert.assertEquals(3, jogosShooter.size());
    }
}

package equipeDFK.sistemaX.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import equipeDFK.sistemaX.entidades.Feriado;
import equipeDFK.sistemaX.openCSV.OpenCSV;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kaique
 */
public class ClasseTeste {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        //GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        //gu.cadastrar(new Usuario("email", "kaique Candido", "senha", "foto", "tipo", "matri"));        

        File filename = new File("D://teste.csv");
        OpenCSV open = new OpenCSV();
        open.lerCSV(filename);

    }

}

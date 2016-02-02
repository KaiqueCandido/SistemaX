package equipeDFK.sistemaX.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import equipeDFK.sistemaX.entidades.Feriado;
import equipeDFK.sistemaX.entidades.Usuario;
import equipeDFK.sistemaX.gerenciadores.GerenciadorDeFeriado;
import equipeDFK.sistemaX.gerenciadores.GerenciadorDeUsuario;
import equipeDFK.sistemaX.openCSV.OpenCSV;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaique
 */
public class ClasseTeste {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        List<Feriado> f = new ArrayList<>();
        f.add(new Feriado("Natal", "25/12/2015", null, null));
        f.add(new Feriado("Natal", "05/2/2016", null, null));
        gf.importaferiado(f, true);
        

    }

}

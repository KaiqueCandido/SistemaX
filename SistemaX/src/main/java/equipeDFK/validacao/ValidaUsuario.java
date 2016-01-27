/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.validacao;

import equipeDFK.entidades.Usuario;

/**
 *
 * @author kaique
 */
public class ValidaUsuario {

    public boolean validaNomeDeUsuario(Usuario usuario) {
        // Validação de Nome de Usuario

        //Verifica se o nome de usuario contem algum caractere invalido
        String caracteresEspeciais[] = {"!","%", "-", "$", "_", "#", "@", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " "};
        for (int i = 0; i < caracteresEspeciais.length; i++) {
            if (usuario.getNome().contains(caracteresEspeciais[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean validaSenha(Usuario usuario) {
        // Validação da senha

        //Verifica o tamanho da senha
        if (usuario.getSenha().length() < 7) {
            return false;
        }

        //Verifica se na senha contem pelo menos  carctere maisculo
        boolean TemCaractereMaiscula = false;
        for (int i = 0; i < usuario.getSenha().length(); i++) {
            String aux = "" + usuario.getSenha().charAt(i);
            if (aux.toUpperCase().equals(aux)) {
                TemCaractereMaiscula = true;
            }
        }
        if (TemCaractereMaiscula == false) {
            return false;
        }

        //Verifica se na senha contem algum caractere não alfabetico
        boolean TemCractereNaoAlabetico = false;
        String caracteresEspeciaisDaSenha[] = {"!", "$", "#", "%"};
        for (int i = 0; i < caracteresEspeciaisDaSenha.length; i++) {
            if (usuario.getSenha().contains(caracteresEspeciaisDaSenha[i])) {
                TemCractereNaoAlabetico = true;
            }
        }
        if (TemCractereNaoAlabetico == false) {
            return false;
        }
        return true;
    }

    public boolean validaMatricula(Usuario usuario) {
        // Validação de matricula
        //Verifica o tamanho da matricula
        if (usuario.getMatricula().length() == 6) {
            return true;
        }
        return false;
    }
}

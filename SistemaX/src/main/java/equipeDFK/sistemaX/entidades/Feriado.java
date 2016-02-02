/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.entidades;

/**
 * Classe que representa a entidade Feriado
 * @author NandaPC
 */
public class Feriado {

    private String title;
    private String start;
    private String end;
    private String url;

    /**
     * Construtor default
     */
    public Feriado() {
    }

    /**
     * Construtor com parâmetros
     * @param title
     * @param start
     * @param end
     * @param url 
     */
    public Feriado(String title, String start, String end, String url) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Feriado{" + "title=" + title + ", start=" + start + ", end=" + end + ", url=" + url + '}';
    }

}

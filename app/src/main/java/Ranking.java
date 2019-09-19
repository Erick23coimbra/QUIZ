import android.os.Build;

import java.util.Objects;

public class Ranking {
    private String nome;
    private String Pontos;


    public Ranking(String nome, String pontos) {
        this.nome = nome;
        Pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPontos() {
        return Pontos;
    }

    public void setPontos(String pontos) {
        Pontos = pontos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ranking)) return false;
        Ranking ranking = (Ranking) o;
        return getNome().equals(ranking.getNome()) &&
                getPontos().equals(ranking.getPontos());
    }

    @Override
    public int hashCode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Objects.hash(getNome(), getPontos());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "nome='" + nome + '\'' +
                ", Pontos='" + Pontos + '\'' +
                '}';
    }
}

package rosa.ribeiro.jonas.dto;

import java.util.ArrayList;
import java.util.List;

public class NotasDto {

    private String nNota;
    private String dataEmissao;
    private String tipoOperacao;
    private String nomeEmpresa;
    private List<String> emailList;

    public NotasDto(String nNota, String dataEmissao, String tipoOperacao, String nomeEmpresa, List<String> emailList) {
        this.nNota = nNota;
        this.dataEmissao = dataEmissao;
        this.tipoOperacao = tipoOperacao;
        this.nomeEmpresa = nomeEmpresa;
        this.emailList = new ArrayList<>(emailList);
    }

    public String getnNota() {
        return nNota;
    }

    public void setnNota(String nNota) {
        this.nNota = nNota;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    public String emailBody(){
        return String.format("""
                        
                        
                        - Nota: %s
                        - Emissão: %s
                        """,
                nNota, dataEmissao
        );
    }

    @Override
    public String toString() {
        return String.format("\n\n" +
                        "- Nota: %s\n" +
                        "- Emissão: %s\n" +
                        "- Empresa: %s\n" +
                        "- Tipo de Operação: %s\n"+
                        "- emailList: %s",
                nNota, dataEmissao, tipoOperacao, nomeEmpresa, emailList
                );
    }
}

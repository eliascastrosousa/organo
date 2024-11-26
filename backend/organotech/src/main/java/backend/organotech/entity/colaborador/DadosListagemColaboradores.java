package backend.organotech.entity.colaborador;

import backend.organotech.entity.time.Time;

public record DadosListagemColaboradores(
        String nome,
        String cargo,
        String imagem,
        Time time) {
//    public DadosListagemColaboradores(Colaborador colaborador){
//        //this(colaborador.getNome(), colaborador.getCargo(), colaborador.getImagem());
//    }
}


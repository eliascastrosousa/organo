import "./Jogador.css";

const Jogador = ({
  nome,
  sobrenome,
  posicao,
  imagem,
  escudo,
  corSecundaria,
  corTerciaria,
}) => {
  return (
    <div className="jogador">
      <div className="cabecalho" style={{ background: corSecundaria }}>
        <img src={imagem} alt={nome} className="imagem" />
      </div>
      <div className="rodape" >
        <div className="texto">
        <h4>
          {nome} {sobrenome}{" "}
        </h4>
        <h5>{posicao}</h5>
        </div>
       
      </div>
      
    </div>
  );
};

export default Jogador;

import './Jogador.css'

const Jogador = ({nome, sobrenome, posicao, imagem}) => {
    const css = { opacity: 0.6 }
    return (
    <div className='jogador'> 
        <div className='cabecalho'  >
            <img src={imagem} alt={nome} />
        </div>
        <div className='rodape'>
            <h4>{nome} {sobrenome} </h4>
            <h5>{posicao}</h5>
        </div>
    </div>
)
}

export default Jogador
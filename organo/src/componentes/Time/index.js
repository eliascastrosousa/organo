import Jogador from '../Jogador/Index'
import './Time.css'

const Time = (props) => {
    const css = { backgroundColor: props.corSecundaria}

    return (
       
        (props.jogadores.length > 0) ? <section className='time' style={css}>
            <h3 style={{ borderColor: props.corPrimaria }}>{props.nome}</h3>
            <div className='jogadores'>
                {props.jogadores.map( jogador => <Jogador nome={jogador.nome} key={jogador.nome} sobrenome={jogador.sobrenome} posicao={jogador.posicao} imagem={jogador.imagem} dataNasc={jogador.dataNasc} corPrimaria={props.corPrimaria} corSecundaria={props.corSecundaria}/> )}
            </div>
        </section>  : null
        
    ) 
}

export default Time